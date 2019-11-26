package employee;

import common.GeneralRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Сервлет просмотра списков сотрудников.
 */
public class EmployeeListServlet extends HttpServlet {

    private GeneralRepository<Employee> repository = new EmployeeRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Employee> employees = repository.getList();

        req.setAttribute("employees",employees);
        req.getRequestDispatcher("/jsp/employees.jsp").forward(req,resp);
    }
}
