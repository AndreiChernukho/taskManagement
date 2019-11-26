package project;

import common.GeneralRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет просмотра/редактирования проекта
 */
public class ProjectServlet extends HttpServlet {

    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private GeneralRepository<Project> repository = new ProjectRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id"); //
        String action = req.getParameter("action");
        if (EDIT_ACTION.equals(action)) {
            Project project = repository.get(id);
            req.setAttribute("project", project);
            req.getRequestDispatcher("/jsp/projectEditPage.jsp").forward(req, resp);
        } else if (DELETE_ACTION.equals(action)) {
            repository.delete(id);
            resp.sendRedirect("projects");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = "".equals(req.getParameter("id")) ? null : req.getParameter("id");
        String name = req.getParameter("name");
        if ("".equals(name)) {
            req.setAttribute("nameError", "Поле обязательно для заполнения");
            req.getRequestDispatcher("/jsp/projectEditPage.jsp").forward(req, resp);
            return;
        }
        String description = req.getParameter("description");

        repository.save(new Project(id, name, description));
        resp.sendRedirect("projects");
    }
}
