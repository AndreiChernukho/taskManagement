package task;

import employee.Employee;
import project.Project;

/**
 * Задача.
 */
public class Task {

    /**
     * Идентификатор.
     */
    private String id;

    /**
     * Статус.
     */
    private TaskStatus status;

    /**
     * Название.
     */
    private String name;

    /**
     * Проект.
     */
    private Project project;

    /**
     * Сотрудник.
     */
    private Employee employee;

    public Task() {
    }

    public Task(String id, TaskStatus status, String name, Project project, Employee employee) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.project = project;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
