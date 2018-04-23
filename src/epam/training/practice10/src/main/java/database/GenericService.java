package database;

import database.connection.DatabaseConnection;

import java.sql.Connection;

public class GenericService <T> {
    protected final Connection connection = DatabaseConnection.getConnection();
    protected final GenericDAO<T> dao;

    public GenericService(GenericDAO<T> dao) {
        this.dao = dao;
    }
}
