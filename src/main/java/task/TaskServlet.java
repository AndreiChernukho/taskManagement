package task;

import common.GeneralRepository;
import employee.Employee;
import employee.EmployeeRepository;
import project.Project;
import project.ProjectRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TaskServlet extends HttpServlet {

    private static final String ADD_ACTION = "add";
    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private static final String PREVIEW_PAGE = "projects";
    private GeneralRepository<Project> projectRepository = new ProjectRepository(); //создан обьект для работы с базой данных
    private GeneralRepository<Employee> employeeRepository = new EmployeeRepository();
    private GeneralRepository<Task> taskRepository = new TaskRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String previewPage = req.getParameter("previewPage");
        if (ADD_ACTION.equals(action)) {
            List<Project> projects = projectRepository.getList();
            req.setAttribute("projects", projects);
            List<Employee> employees = employeeRepository.getList();
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("jsp/taskEditPage.jsp").forward(req, resp);// из реквеста получили реквестдиспетчер
            // для джсп страницы и вызвали у реквест диспетчера метод ворвард который перенаправил на нужную страницу
        } else if (EDIT_ACTION.equals(action)) {
            Task task = taskRepository.get(req.getParameter("id"));
            req.setAttribute("task", task);
            List<Project> projects = projectRepository.getList();
            req.setAttribute("projects", projects);
            List<Employee> employees = employeeRepository.getList();
            req.setAttribute("employees", employees);
            if (PREVIEW_PAGE.equals(previewPage)) {
                req.setAttribute("previewPage", previewPage);
            }
            req.getRequestDispatcher("jsp/taskEditPage.jsp").forward(req, resp);
        } else if (DELETE_ACTION.equals(action)) {
            taskRepository.delete(req.getParameter("id"));
            resp.sendRedirect("tasks");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Task task = "".equals(id) ? new Task() : taskRepository.get(id);

        String name = req.getParameter("name");
        task.setName(name);

        TaskStatus status = TaskStatus.valueOf(req.getParameter("status"));
        task.setStatus(status);

        String employeeId = req.getParameter("employeeId");
        Employee employee = employeeRepository.get(employeeId);
        task.setEmployee(employee);

        String projectId = req.getParameter("projectId");
        if (projectId != null) {
            Project project = projectRepository.get(projectId);
            task.setProject(project);
        }

        taskRepository.save(task);
        String previewPage = req.getParameter("previewPage");

        if (PREVIEW_PAGE.equals(previewPage)) {
            Project project = task.getProject();
            resp.sendRedirect("tasks?projectId="+project.getId()+"&previewPage=projects");
        } else {
            resp.sendRedirect("tasks");
        }
    }
}
