package task;

import common.GeneralRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TaskListServlet extends HttpServlet {

    private TaskRepository repository = new TaskRepositoryImpl(); // создаем обьект репозитория для работы с БД

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("projectId");
        List<Task> tasks;
        if (projectId == null || "".equals(projectId)) {
            tasks = repository.getList();
        } else {
            tasks = repository.getTasks(projectId);
            String previewPage = "projects";
            req.setAttribute("previewPage", previewPage);
        }
        //List<Task> tasks = projectId==null || "".equals(projectId)?repository.getList():repository.getTasks(projectId);
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("jsp/tasks.jsp").forward(req, resp);
    }
}
