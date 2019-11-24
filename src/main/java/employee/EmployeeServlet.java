package employee;

import common.GeneralRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
    private static final String EDIT_ACTION = "edit";
    private static final String DELETE_ACTION = "delete";
    private GeneralRepository<Employee> repository = new EmployeeRepository(); //создан обьект для работы с базой данных

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String action = req.getParameter("action");
        if (EDIT_ACTION.equals(action)) {
            Employee employee = repository.get(id);
            req.setAttribute("employee", employee);
            req.getRequestDispatcher("/jsp/employeeEditPage.jsp").forward(req, resp);
        } else if (DELETE_ACTION.equals(action)) {
            repository.delete(id);
            resp.sendRedirect("employees"); //обновляем нашу страницу проекта
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = "".equals(req.getParameter("id")) ? null : req.getParameter("id");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String patronymic = req.getParameter("patronymic");
        String position = req.getParameter("position");

        repository.save(new Employee(id, surname, name, patronymic, position));
        resp.sendRedirect("employees");
    }
}


