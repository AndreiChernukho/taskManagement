package setting;

public class Setting {
    private final static String settingId = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private String urlServer; //URL сервера
    private int maxLine; //Максимальное количество записей в списках
    private int numberOfDays; //Количество дней по умолчанию между начальной и конечной датами в задаче

    public Setting(String urlServer, int maxLine, int numberOfDays) {

        this.urlServer = urlServer;
        this.maxLine = maxLine;
        this.numberOfDays = numberOfDays;
    }

    public String getUrlServer() {
        return urlServer;
    }

    public void setUrlServer(String urlServer) {
        this.urlServer = urlServer;
    }

    public int getMaxLine() {
        return maxLine;
    }

    public void setMaxLine(int maxLine) {
        this.maxLine = maxLine;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}

