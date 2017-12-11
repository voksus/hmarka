package net.repetitor.dao.impl;

import net.repetitor.dao.AbstractDao;
import net.repetitor.dao.Dao;
import net.repetitor.model.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Volodymyr Burtsev at 06.12.2017 16:16
 */
public class CountryDaoImpl extends AbstractDao implements Dao<Country> {

    private static List<Country> countries;

    @Override
    public void create(Country country) {
    }

    @Override
    public List<Country> readAll() {

        if (countries != null) return countries;

        countries = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM countries");
            while (rs.next()) {
                countries.add(new Country(
                        rs.getInt("id"),
                        rs.getString("name"))
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

        return countries;
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public void delete(Country country) {

    }

    @Override
    public Country getById(int id) {
        return null;
    }
}