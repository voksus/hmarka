package net.repetitor.dao;

import java.util.List;

/**
 * @author Volodymyr Burtsev at 06.12.2017 15:58
 */
public interface Dao<T> {

    void create(T value);
    List<T> readAll();
    void update(T value);
    void delete(T value);

    T getById(int id);

}