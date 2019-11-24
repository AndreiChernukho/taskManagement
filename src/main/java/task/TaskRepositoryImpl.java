package task;

import common.ConnectionService;
import common.GeneralRepository;
import employee.Employee;
import employee.EmployeeRepository;
import project.Project;
import project.ProjectRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepositoryImpl implements TaskRepository{

    private GeneralRepository<Project> projectRepository = new ProjectRepository();
    private GeneralRepository<Employee> employeeRepository = new EmployeeRepository();


    @Override
    public void save(Task task) {
        if (task.getId() == null) {
            insert(task);
        } else {
            update(task);
        }

    }


    private void insert(Task task) {
        String query = "INSERT INTO task (id, status, name, project_id, employee_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionService.getConnection(); //Получили нонешен
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {

            preparedStatement.setString(1, task.getId() == null ? UUID.randomUUID().toString() : task.getId());
            preparedStatement.setString(2, task.getStatus().name());
            preparedStatement.setString(3, task.getName());
            preparedStatement.setString(4, task.getProject().getId());
            preparedStatement.setString(5, task.getEmployee().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void update(Task task) {
        String query = "UPDATE  task SET status = ?, name =? , project_id = ?, employee_id = ? WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection(); //Получили нонешен
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {

            preparedStatement.setString(1, task.getStatus().name());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getProject().getId());
            preparedStatement.setString(4, task.getEmployee().getId());
            preparedStatement.setString(5, task.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getList() {

        List<Task> tasks = new ArrayList<>();
        String query = "SELECT id, status, name, project_id, employee_id FROM task";
        try (Connection connection = ConnectionService.getConnection(); //Получили нонешен
             Statement statement = connection.createStatement()) { //получили обьект, чтобы делать запросы
            ResultSet resultSet = statement.executeQuery(query); // получили ответ на запрос в виде резалт сета
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                TaskStatus status = TaskStatus.valueOf(resultSet.getString("status"));
                String name = resultSet.getString("name");
                String projectId = resultSet.getString("project_id");
                String employeeId = resultSet.getString("employee_id");
                Project project = projectRepository.get(projectId);
                Employee employee = employeeRepository.get(employeeId);

                Task task = new Task(id, status, name, project, employee);
                tasks.add(task);
            }
//
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    public Task get(String id) {
        String query = "SELECT status, name, project_id, employee_id FROM task WHERE id=?";
        Task task = null;
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TaskStatus status = TaskStatus.valueOf(resultSet.getString("status"));
                String name = resultSet.getString("name");
                String projectId = resultSet.getString("project_id");
                String employeeId = resultSet.getString("employee_id");
                Project project = projectRepository.get(projectId);
                Employee employee = employeeRepository.get(employeeId);
                task = new Task(id, status, name, project, employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return task;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM task WHERE id=?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getTasks(String projectId) {
        List<Task> tasks = new ArrayList<>();
        Project project = projectRepository.get(projectId);
        String query = "SELECT id, status, name, employee_id FROM task WHERE project_id=?";
        try (Connection connection = ConnectionService.getConnection(); //Получили нонешен
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {

            preparedStatement.setString(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("id");
                TaskStatus status = TaskStatus.valueOf(resultSet.getString("status"));
                String name = resultSet.getString("name");
                String employeeId = resultSet.getString("employee_id");

                Employee employee = employeeRepository.get(employeeId);

                Task task = new Task(id, status, name, project, employee);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
