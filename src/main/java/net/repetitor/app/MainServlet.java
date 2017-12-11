package net.repetitor.app;

import net.repetitor.dao.Dao;
import net.repetitor.dao.impl.CountryDaoImpl;
import net.repetitor.dao.impl.EmployeeDaoImpl;
import net.repetitor.dao.impl.OrderDaoImpl;
import net.repetitor.dao.impl.RegionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Volodymyr Burtsev at 08.12.2017 7:54
 */
@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet {

    private Dao oDao;
    private Dao eDao;
    private Dao rDao;
    private Dao cDao;

    @Override
    public void init() {
        oDao = new OrderDaoImpl();
        eDao = new EmployeeDaoImpl();
        rDao = new RegionDaoImpl();
        cDao = new CountryDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("orders", oDao.readAll());
        req.setAttribute("employees", eDao.readAll());
        req.setAttribute("regions", rDao.readAll());
        req.setAttribute("countries", cDao.readAll());

        if (req.getAttribute("current_page") == null || ((String) req.getAttribute("current_page")).isEmpty()) {
            req.setAttribute("current_page", "add_order");
        }

        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        req.setAttribute("date", formatDate.format(new Date()));

        if (req.getRequestURI().equals("/add_order")) {
            req.setAttribute("current_page", "add_order");
        }
        if (req.getRequestURI().equals("/statistics")) {
            req.setAttribute("current_page", "statistics");
        }

        req.getRequestDispatcher("mpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getAttribute("current_page") == null) {
            req.setAttribute("current_page", "add_order");
        }

        req.getRequestDispatcher("mpage.jsp").forward(req, resp);
    }

}