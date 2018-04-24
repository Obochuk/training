package model.database.dao;

import model.database.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, K> {
    Connection CONNECTION = DatabaseConnection.getConnection();

    List<T> getAll() throws SQLException;

    T getById(K id) throws SQLException;

    boolean delete(T elem) throws SQLException;

    boolean upsert(T elem) throws SQLException;

}
