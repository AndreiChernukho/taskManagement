package setting;

import common.GeneralRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Settings extends HttpServlet {

    private GeneralRepository<Setting> repository = new SettingRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Setting settings = repository.get("QWERTYUIOPASDFGHJKLZXCVBNM1234567890");

        req.setAttribute("settings",settings);
        req.getRequestDispatcher("/jsp/settings.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String urlServer = req.getParameter("urlServer");
        int maxLine = Integer.parseInt(req.getParameter("maxLine"));
        int numberOfDays = Integer.parseInt(req.getParameter("numberOfDays"));

        repository.save(new Setting(urlServer, maxLine ,numberOfDays));
        resp.sendRedirect("index.jsp");
    }
}
