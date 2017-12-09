package net.repetitor.dao.impl;

import net.repetitor.dao.AbstractDao;
import net.repetitor.dao.EmployeeDao;
import net.repetitor.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Volodymyr Burtsev at 06.12.2017 16:03
 */
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

    @Override
    public void create(Employee employee) {}

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");
            Employee employee;
            while (rs.next()) {
                employee = new Employee(rs.getString("login"), rs.getString("name"));
                employee.setId(rs.getInt("id"));
                employees.add(employee);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employees;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public Employee getById(int id) {
        return null;
    }
}