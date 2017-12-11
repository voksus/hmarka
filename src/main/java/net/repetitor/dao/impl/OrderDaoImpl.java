package net.repetitor.dao.impl;

import net.repetitor.dao.AbstractDao;
import net.repetitor.dao.Dao;
import net.repetitor.model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Volodymyr Burtsev at 06.12.2017 16:05
 */
public class OrderDaoImpl extends AbstractDao implements Dao<Order> {

    private static List<Order> orders;

    @Override
    public void create(Order order) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO orders (employee_login, region_id, price, date) VALUES (?, ?, ?, ?)");
                ps.setString(1, order.getEmployeeLogin());
                ps.setInt(2, order.getRegionId());
                ps.setInt(3, order.getPrice());
                ps.setTimestamp(4, order.getTimestamp());
                ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Order> readAll() {

        if (orders != null) return orders;

        orders = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM orders");
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("id"),
                        rs.getString("employee_login"),
                        rs.getInt("region_id"),
                        rs.getInt("price"),
                        rs.getTimestamp("date"))
                );
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

        return orders;
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public Order getById(int id) {
        return null;
    }

}