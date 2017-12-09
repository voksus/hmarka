package net.repetitor.app;

import net.repetitor.dao.EmployeeDao;
import net.repetitor.dao.impl.CountryDaoImpl;
import net.repetitor.dao.impl.EmployeeDaoImpl;
import net.repetitor.dao.impl.OrderDaoImpl;
import net.repetitor.dao.impl.RegionDaoImpl;
import net.repetitor.model.Country;
import net.repetitor.model.Employee;
import net.repetitor.model.Order;
import net.repetitor.model.Region;
import org.apache.commons.dbcp.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet {

    private OrderDaoImpl oDao;
    private EmployeeDao eDao;
    private RegionDaoImpl rDao;
    private CountryDaoImpl cDao;

    @Override
    public void init() {
        oDao = new OrderDaoImpl();
        eDao = new EmployeeDaoImpl();
        rDao = new RegionDaoImpl();
        cDao = new CountryDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = oDao.readAll();
        List<Employee> employees = eDao.readAll();
        List<Region> regions = rDao.readAll();
        List<Country> countries = cDao.readAll();
        req.setAttribute("orders", orders);
        req.setAttribute("employees", employees);
        req.setAttribute("regions", regions);
        req.setAttribute("countries", countries);
//        System.out.println("--> gSP : " + req.getServletPath());
//        System.out.println("--> gAT : " + req.getAuthType());
//        System.out.println("--> gQS : " + req.getQueryString());
//        System.out.println("--> gRU : " + req.getRemoteUser());
//        System.out.println("--> gRURI : " + req.getRequestURI());
//        System.out.println("--> gRSId : " + req.getRequestedSessionId());
        req.getRequestDispatcher("mpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" Marry christmas ");
        /*int employeeId = Integer.valueOf(req.getParameter("employee.id"));
        String employeeLogin = req.getParameter("employee.login");
        String employeeName = req.getParameter("employee.name");

        if (!employeeName.isEmpty() && !employeeLogin.isEmpty()) {
            Employee employee = new Employee(employeeLogin, employeeName);
            employee.setId(employeeId);
            employees.add(employee);
            req.setAttribute("employees", employees);
        } else {
            resp.getWriter().println("you enter empty employee - rewrite employee");
            req.setAttribute("employees", employees);
        }*/
        req.getRequestDispatcher("mpage.jsp").forward(req, resp);
    }

}