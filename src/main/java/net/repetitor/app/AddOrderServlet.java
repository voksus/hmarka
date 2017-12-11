package net.repetitor.app;

import net.repetitor.dao.Dao;
import net.repetitor.dao.impl.CountryDaoImpl;
import net.repetitor.dao.impl.EmployeeDaoImpl;
import net.repetitor.dao.impl.OrderDaoImpl;
import net.repetitor.dao.impl.RegionDaoImpl;
import net.repetitor.model.Employee;
import net.repetitor.model.Order;
import net.repetitor.model.Region;

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

/**
 * @author Volodymyr Burtsev at 10.12.2017 2:52
 */
@WebServlet(name = "AddOrderServlet", urlPatterns = "/add_order")
public class AddOrderServlet extends HttpServlet {

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
        System.out.println("ADD_ORDER servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("orders", oDao.readAll());
        req.setAttribute("employees", eDao.readAll());
        req.setAttribute("regions", rDao.readAll());
        req.setAttribute("countries", cDao.readAll());

        try {
            String employeeLogin = ((Employee) eDao
                    .getById(Integer.parseInt(req.getParameter("employee")))).getLogin();
            System.out.println(employeeLogin);

            int regionId = Integer.valueOf(req.getParameter("region"));
            System.out.println(regionId);

            int price = Integer.valueOf(req.getParameter("price"));
            System.out.println(price);

            SimpleDateFormat getDate = new SimpleDateFormat("dd-MM-yyyy");
            Date date = getDate.parse(req.getParameter("date"));
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println(timestamp);

            Order order = new Order(0, employeeLogin, regionId, price, timestamp);
            oDao.create(order);

            req.setAttribute("info_msg", "New order was added.");
        } catch (ParseException e) {
            System.err.println("ParseException");
            req.setAttribute("alert_msg", "Please enter correct date!");
            doGet(req, resp);
        } catch (Exception e) {
            System.err.println("Some error :(");
            req.setAttribute("alert_msg", "!!! ERROR !!!");
            System.out.println(e.getMessage());
        }

        req.setAttribute("current_page", "add_order");
        req.getRequestDispatcher("mpage.jsp").forward(req, resp);

//        super.doPost(req, resp);
    }

}