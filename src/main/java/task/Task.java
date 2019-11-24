package task;

import employee.Employee;
import project.Project;

public class Task {

    private String id;

    private TaskStatus status;

    private String name;

    private Project project;

    private Employee employee;

    public Task(String id, TaskStatus status, String name, Project project, Employee employee) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.project = project;
        this.employee = employee;
    }

    public Task() {

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

