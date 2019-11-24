package project;

/**
 * Проект.
 */
public class Project {

    /**
     * Индентификатор.
     */
    private String id;

    /**
     *  Название.
     */
    private String name;

    /**
     * Описание.
     */
    private String description;

    public Project(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Project() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
