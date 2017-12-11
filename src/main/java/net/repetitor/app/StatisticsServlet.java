package net.repetitor.app;

import net.repetitor.dao.EmployeeDao;
import net.repetitor.dao.impl.CountryDaoImpl;
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

    private OrderDaoImpl oDao;
    private EmployeeDao eDao;
    private RegionDaoImpl rDao;
    private CountryDaoImpl cDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("STATISTICS servlet");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}