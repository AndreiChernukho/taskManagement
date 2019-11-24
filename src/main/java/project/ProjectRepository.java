package project;

import common.ConnectionService;
import common.GeneralRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectRepository implements GeneralRepository<Project> {

    @Override
    public void save(Project project) {
        if (project.getId() == null) {
            insert(project);
        } else {
            update(project);
        }
    }

    private void insert(Project project) {
        String query = "INSERT INTO project(id, name,description) VALUES (?,?,?)";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void update(Project project) {
        String query = "UPDATE project SET name=?, description=? WHERE id=?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> getList() {
        String query = "SELECT id, name, description FROM project";
        List<Project> projects = new ArrayList<>();
        try (Connection connection = ConnectionService.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                Project project = new Project(id, name, description);
                projects.add(project);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Project get(String id) {
        String query = "SELECT id, name, description FROM project WHERE id=?";
        Project project = null;
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
//TODO исправить кидать ошибку если содержит больше одного проекта.
            while (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getString("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM project WHERE id=?";
        try (Connection connection = ConnectionService.getConnection(); //установили соединение
        PreparedStatement preparedStatement = connection.prepareStatement(query)){  //получили обьект для работы с запросами

            preparedStatement.setString(1, id); //установили(дали) параметры
            preparedStatement.execute(); //выполняем запрос

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
