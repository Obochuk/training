package entity.task;

import database.GenericService;
import database.query.Queries;
import entity.worker.Worker;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskService extends GenericService<Task>{
    private final static Logger LOGGER = Logger.getLogger(TaskService.class);
    public TaskService() {
        super(new TaskDAO());
    }

    public List<Task> getAll(){
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL_TASKS)) {

            return dao.select(statement);
        } catch (SQLException e){
            LOGGER.error("Cannot prepare statement", e);
        }
        return new ArrayList<>();
    }

    public List<Task> getTasksOfWorker(Worker worker){
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_TASKS_FOR_WORKER)){

            statement.setInt(1, worker.getId());
            return dao.select(statement);
        } catch (SQLException e){
            LOGGER.error("Cannot prepare statement", e);
        }
        return new ArrayList<>();
    }

    public void addTask(Task task){
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_TASK_FOR_WORKER)) {

            statement.setString(1, task.getDescription());
            statement.setInt(2, task.getUserId());
            dao.update(statement);
        }catch (SQLException e){
            LOGGER.error("Cannot prepare statement", e);
        }
    }
}
