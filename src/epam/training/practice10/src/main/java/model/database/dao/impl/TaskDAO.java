package model.database.dao.impl;

import model.database.dao.GenericDAO;
import model.entity.Task;
import model.entity.Worker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO implements GenericDAO<Task, Integer> {
    private static TaskDAO instance;

    private TaskDAO(){}

    public static TaskDAO getInstance(){
        if (instance == null)
            instance = new TaskDAO();
        return instance;
    }

    private interface Query {
        String GET_ALL = "SELECT * FROM tasks";
        String GET_WORKER_TASKS = "SELECT * FROM tasks WHERE workerId = ?";
        String GET_BY_ID = "SELECT * FROM tasks WHERE id = ?";
        String DELETE = "DELETE FROM tasks WHERE id = ?";
        String UPSERT = "INSERT INTO tasks (id, description, workerId) VALUES(?, ?, ?)" +
                "ON DUPLICATE KEY UPDATE description = ?, workerId = ?";
    }

    @Override
    public List<Task> getAll() throws SQLException {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery(Query.GET_ALL);
        List<Task> tasks = new ArrayList<>();
        while (resultSet.next()){
            tasks.add(retrieveTask(resultSet));
        }
        return tasks;
    }

    public List<Task> getWorkerTasks(Worker worker) throws SQLException{
        PreparedStatement statement = CONNECTION.prepareStatement(Query.GET_WORKER_TASKS);
        statement.setInt(1, worker.getId());
        ResultSet resultSet = statement.executeQuery();
        List<Task> tasks = new ArrayList<>();
        while (resultSet.next()){
            tasks.add(retrieveTask(resultSet));
        }
        return tasks;
    }

    @Override
    public Task getById(Integer id) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.GET_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
            return retrieveTask(resultSet);
        return null;
    }

    @Override
    public boolean delete(Task elem) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.DELETE);
        statement.setInt(1, elem.getId());
        return statement.execute();
    }

    @Override
    public boolean upsert(Task elem) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.UPSERT);
        statement.setInt(1, elem.getId());
        statement.setString(2, elem.getDescription());
        statement.setInt(3, elem.getWorkerId());
        statement.setString(4, elem.getDescription());
        statement.setInt(5, elem.getWorkerId());

        return statement.execute();
    }

    private Task retrieveTask(ResultSet resultSet) throws SQLException{
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setDescription(resultSet.getString("description"));
        task.setWorkerId(resultSet.getInt("workerId"));

        return task;
    }
}
