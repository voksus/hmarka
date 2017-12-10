package net.repetitor.app;

import net.repetitor.dao.EmployeeDao;
import net.repetitor.dao.impl.CountryDaoImpl;
import net.repetitor.dao.impl.EmployeeDaoImpl;
import net.repetitor.dao.impl.OrderDaoImpl;
import net.repetitor.dao.impl.RegionDaoImpl;
import net.repetitor.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        req.setAttribute("orders", oDao.readAll());
        req.setAttribute("employees", eDao.readAll());
        req.setAttribute("regions", rDao.readAll());
        req.setAttribute("countries", cDao.readAll());

        if (req.getParameter("page") == null || req.getParameter("page").isEmpty()) {
            req.setAttribute("page", "make_order");
        }

        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        req.setAttribute("date", formatDate.format(new Date()));
        if (req.getRequestURI().equals("/make_order")) {
            System.out.println("going to MAKE_ORDER");
            req.setAttribute("page", "make_order");
        }
        if (req.getRequestURI().equals("/statistics")) {
            System.out.println("going to STATISTICS");
            req.setAttribute("page", "statistics");
        }

        req.getRequestDispatcher("mpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("page").equals("make_order")) {
            Order order = null;
            try {
                String employeeLogin = eDao.readAll().get(Integer.parseInt(req.getParameter("employee"))).getLogin();
                System.out.println(employeeLogin);

                int regionId = Integer.valueOf(req.getParameter("region"));
                System.out.println(regionId);

                int price = Integer.valueOf(req.getParameter("price"));
                System.out.println(price);

                SimpleDateFormat getDate = new SimpleDateFormat("dd-MM-yyyy");
                Date date = getDate.parse(req.getParameter("date"));
                Timestamp timestamp = new Timestamp(date.getTime());
                System.out.println(timestamp);

                order = new Order(0, employeeLogin, regionId, price, timestamp);
            } catch (ParseException e) {
                System.err.println("ParseException");
                req.setAttribute("alert", "Please enter correct date!");
                doGet(req, resp);
            } catch (Exception e) {
                System.err.println("Some error :(");
                req.setAttribute("alert", "!!! ERROR !!!");
            }
            oDao.create(order);
        }

        req.setAttribute("orders", oDao.readAll());
        req.setAttribute("employees", eDao.readAll());
        req.setAttribute("regions", rDao.readAll());
        req.setAttribute("countries", cDao.readAll());
        req.getRequestDispatcher("mpage.jsp").forward(req, resp);
    }

}