package employee;

import common.ConnectionService;
import common.GeneralRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Репозиторий сотрудников.
 */
public class EmployeeRepository implements GeneralRepository<Employee> {

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            insert(employee);
        } else {
            update(employee);
        }
    }

    @Override
    public List<Employee> getList() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT id, surname, name, patronymic, position FROM employee";

        try (Connection connection = ConnectionService.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String surname = resultSet.getString(2);
                String name = resultSet.getString(3);
                String patronymic = resultSet.getString(4);
                String position = resultSet.getString(5);

                Employee employee = new Employee(id, surname, name, patronymic, position);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee get(String id) {
        String query = "SELECT id, surname, name, patronymic, position FROM employee WHERE id=?";
        Employee employee = null;

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String patronymic = resultSet.getString("patronymic");
                String position = resultSet.getString("position");
                employee = new Employee(id, surname, name, patronymic, position);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void delete(String id) {
        String query = "DELETE FROM employee WHERE id=?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert(Employee employee) {
        String query = "INSERT INTO employee (id, surname, name, patronymic, position) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, employee.getId() == null ? UUID.randomUUID().toString() : employee.getId());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getPatronymic());
            preparedStatement.setString(5, employee.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(Employee employee) {
        String query = "UPDATE  employee SET surname = ?, name =? , patronymic = ?, position = ? WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, employee.getSurname());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getPatronymic());
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.setString(5, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
