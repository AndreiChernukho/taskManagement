package employee;

/**
 * Сотрудники.
 */
public class Employee {

    /**
     * Идентификатор
     */
    private String id;

    /**
     * Фамилия
     */
    private String surname;

    /**
     * Имя
     */
    private String name;

    /**
     * Отчество
     */
    private String patronymic;

    /**
     * Должность
     */
    private String position;

    /**
     * Конструктор.
     *
     * @param id идентификатор
     * @param surname фамилия
     * @param name имя
     * @param patronymic отчество
     * @param position должность
     */
    public Employee(String id, String surname, String name, String patronymic, String position) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
