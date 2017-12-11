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

/**
 * @author Volodymyr Burtsev at 10.12.2017 2:59
 */
@WebServlet(name = "StatisticsServlet", urlPatterns = "/statistics")
public class StatisticsServlet extends HttpServlet {

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
        req.setAttribute("current_page", "statistics");
        req.getRequestDispatcher("mpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}