package setting;

import common.ConnectionService;
import common.GeneralRepository;

import java.sql.*;
import java.util.List;

/**
 * Репозиторий для работы с настройками.
 */
public class SettingRepository implements GeneralRepository<Setting> {

    @Override
    public void save(Setting setting) {
        String query = "UPDATE setting SET url_server =?, max_line =? , number_of_days =?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, setting.getUrlServer());
            preparedStatement.setString(2, Integer.toString(setting.getMaxLine()));
            preparedStatement.setString(3, Integer.toString(setting.getNumberOfDays()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List getList() {
        return null;
    }

    @Override
    public Setting get(String id) {
        Setting setting = null;
        String query = "SELECT url_server, max_line, number_of_days FROM setting";

        try (Connection connection = ConnectionService.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String url_server = resultSet.getString("url_server");
                int max_line = resultSet.getInt("max_line");

                int number_of_days = resultSet.getInt("number_of_days");
                System.out.println(url_server + max_line + number_of_days);
                setting = new Setting(url_server, max_line, number_of_days);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setting;
    }

    @Override
    public void delete(String id) {

    }
}
