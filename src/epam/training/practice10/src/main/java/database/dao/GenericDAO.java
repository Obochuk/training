package database.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class GenericDAO<T> {

    public abstract List<T> select(PreparedStatement statement);

    public abstract int update(PreparedStatement statement);

    <R> R getFiled(GetResultPartFunction<R> func, String fieldName){
        try {
            return func.apply(fieldName);
        } catch (SQLException e){
            return null;
        }
    }

    @FunctionalInterface
    protected interface GetResultPartFunction<R> {
        R apply(String fieldName) throws SQLException;
    }

}
