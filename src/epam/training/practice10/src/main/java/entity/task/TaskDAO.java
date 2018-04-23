package entity.task;

import database.GenericDAO;
import org.apache.log4j.Logger;
import view.message.LogMessage;

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
            LOGGER.error(LogMessage.SELECT_ERROR, e);
        }
        return tasks;
    }

    @Override
    public int update(PreparedStatement statement) {
        try {
            return statement.executeUpdate();
        } catch (SQLException e){
            LOGGER.error(LogMessage.UPDATE_ERROR, e);
        }
        return 0;
    }
}
