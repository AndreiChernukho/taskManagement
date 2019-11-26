package project;

import common.GeneralRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Сервлет просмотра списка проектов.
 */
public class ProjectListServlet extends HttpServlet {

    private GeneralRepository<Project> repository = new ProjectRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Project> projects = repository.getList();

        req.setAttribute("projects", projects);
        req.getRequestDispatcher("/jsp/projects.jsp").forward(req, resp);
    }
}
