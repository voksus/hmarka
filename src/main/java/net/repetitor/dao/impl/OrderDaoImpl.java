package net.repetitor.dao.impl;

import net.repetitor.dao.AbstractDao;
import net.repetitor.dao.Dao;
import net.repetitor.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Volodymyr Burtsev at 06.12.2017 16:05
 */
public class OrderDaoImpl extends AbstractDao implements Dao<Order> {

    @Override
    public void create(Order order) {

    }

    @Override
    public List<Order> readAll() {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM orders");
            Order order;
            while (rs.next()) {
                order = new Order(
                        rs.getString("employee_login"),
                        rs.getInt("region_id"),
                        rs.getInt("price"),
                        rs.getTimestamp("date"));
                order.setId(rs.getInt("id"));
                orders.add(order);
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