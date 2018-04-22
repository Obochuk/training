package database.dao;

import entity.Task;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO extends GenericDAO<Task> {
    private final static Logger LOGGER = Logger.getLogger(TaskDAO.class);

    @Override
    public List<Task> select(PreparedStatement statement) {
        List<Task> tasks = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Task task = new Task();
                task.setId(getFiled(result::getInt, "id"));
                task.setDescription(getFiled(result::getString, "description"));
                task.setUserId(getFiled(result::getInt, "userId"));
            }
        } catch (SQLException e){
            LOGGER.error("Error executing select query", e);
        }
        return tasks;
    }

    @Override
    public int update(PreparedStatement statement) {
        try {
            return statement.executeUpdate();
        } catch (SQLException e){
            LOGGER.error("Cannot execute update query", e);
        }
        return 0;
    }
}
