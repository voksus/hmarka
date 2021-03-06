package net.repetitor.dao.impl;

import net.repetitor.dao.AbstractDao;
import net.repetitor.dao.Dao;
import net.repetitor.model.Employee;
import net.repetitor.model.Region;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Volodymyr Burtsev at 06.12.2017 16:08
 */
public class RegionDaoImpl extends AbstractDao implements Dao<Region> {

    private static List<Region> regions;

    @Override
    public void create(Region region) {
    }

    @Override
    public List<Region> readAll() {

        if (regions != null) return regions;

        regions = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM regions");
            while (rs.next()) {
                regions.add(new Region(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("country_id")
                        )
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

        return regions;
    }

    @Override
    public void update(Region region) {

    }

    @Override
    public void delete(Region region) {

    }

    @Override
    public Region getById(int id) {
        return null;
    }

}