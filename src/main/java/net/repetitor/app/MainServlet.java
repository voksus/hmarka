package net.repetitor.app;

import net.repetitor.model.Country;
import net.repetitor.model.Employee;
import net.repetitor.model.Order;
import net.repetitor.model.Region;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet {

    private static List<Employee> employees = new ArrayList<>();
    private static List<Region> regions = new ArrayList<>();
    private static List<Country> countries = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    private static Connection connection;
    private static String url = "jdbc:mysql://127.0.0.1:3306/hmarka?useSSL=false";
    private static String name = "root";
    private static String password = "120378";

    public MainServlet() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, name, password);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employee");
        System.out.println("Employees");
        Employee e = null;
        while (rs.next()) {
            e = new Employee(rs.getString("login"), rs.getString("name"));
            e.setId(rs.getInt("id"));
            System.out.println("#" + e.getId() + "\t" + e.getLogin() + "\t" + e.getName());
            employees.add(e);
        }

        /*
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee where id > ? and id < ?");
        ps.setInt(1, 2);
        ps.setInt(2, 10);
        ResultSet rs2 = ps.executeQuery();

        while (rs2.next()) {
            System.out.println("Номер в выборке #" + rs2.getRow()
                    + "\t Номер в базе #" + rs2.getInt("id")
                    + "\t" + rs2.getString("username"));
        }

        ps = connection.prepareStatement("INSERT INTO users(username) values(?)");
        ps.setString(1, "user_name");
        ps.executeUpdate();
        */

        if (connection != null) connection.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.valueOf(req.getParameter("employee.id"));
        String employeeLogin = req.getParameter("employee.login");
        String employeeName = req.getParameter("employee.name");

        if (!employeeName.isEmpty() && !employeeLogin.isEmpty()) {
            Employee employee = new Employee(employeeLogin, employeeName);
            employee.setId(employeeId);
            employees.add(employee);
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            resp.getWriter().println("you enter empty employee - rewrite employee");
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(List<Employee> employees) {
        MainServlet.employees = employees;
    }

}