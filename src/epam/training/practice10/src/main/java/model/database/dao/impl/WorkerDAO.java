package model.database.dao.impl;

import model.database.dao.GenericDAO;
import model.entity.Department;
import model.entity.Worker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO implements GenericDAO<Worker, Integer> {
    private static WorkerDAO instance;

    private WorkerDAO(){}

    public static WorkerDAO getInstance(){
        if (instance == null)
            instance = new WorkerDAO();
        return instance;
    }

    private interface Query {
        String GET_ALL = "SELECT * FROM workers";
        String GET_DEPARTMENT_WORKERS = "SELECT * FROM workers WHERE departmentId = ?";
        String GET_BY_ID = "SELECT * FROM workers WHERE id = ?";
        String DELETE = "DELETE FROM workers WHERE id = ?";
        String MERGE = "INSERT INTO workers (id, name, surname, position, departmentId) VALUES(?, ?, ?, ?, ?)" +
                "ON DUPLICATE KEY UPDATE name = ?, surname = ?, position = ?, departmentId = ?";
        String INSERT = "INSERT INTO workers(name, surname, position, departmentId) VALUES(?, ?, ?, ?)";
    }

    @Override
    public List<Worker> getAll() throws SQLException {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery(Query.GET_ALL);
        List<Worker> workers = new ArrayList<>();
        while (resultSet.next()){
            workers.add(retrieveWorker(resultSet));
        }
        return workers;
    }

    public List<Worker> getWorkersOfDepartment(Department department) throws SQLException{
        PreparedStatement statement = CONNECTION.prepareStatement(Query.GET_DEPARTMENT_WORKERS);
        statement.setInt(1, department.getId());
        ResultSet resultSet = statement.executeQuery();
        List<Worker> workers = new ArrayList<>();
        while (resultSet.next()){
            workers.add(retrieveWorker(resultSet));
        }
        return workers;

    }

    @Override
    public Worker getById(Integer id) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.GET_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next())
            return retrieveWorker(resultSet);
        return null;
    }

    @Override
    public boolean delete(Worker elem) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.DELETE);
        statement.setInt(1, elem.getId());

        return statement.execute();
    }

    @Override
    public boolean merge(Worker elem) throws SQLException {
        if (elem.getId() == null)
            return insert(elem);

        PreparedStatement statement = CONNECTION.prepareStatement(Query.MERGE);
        statement.setInt(1, elem.getId());
        statement.setString(2, elem.getName());
        statement.setString(3, elem.getSurname());
        statement.setString(4, elem.getPosition());
        statement.setInt(5, elem.getDepartmentId());
        statement.setString(6, elem.getName());
        statement.setString(7, elem.getSurname());
        statement.setString(8, elem.getPosition());
        statement.setInt(9, elem.getDepartmentId());

        return statement.execute();
    }

    @Override
    public boolean insert(Worker elem) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.INSERT);
        statement.setString(1, elem.getName());
        statement.setString(2, elem.getSurname());
        statement.setString(3, elem.getPosition());
        statement.setInt(4, elem.getDepartmentId());

        return statement.execute();
    }

    private Worker retrieveWorker(ResultSet resultSet) throws SQLException{
        Worker worker = new Worker();
        worker.setId(resultSet.getInt("id"));
        worker.setName(resultSet.getString("name"));
        worker.setSurname(resultSet.getString("surname"));
        worker.setPosition(resultSet.getString("position"));
        worker.setDepartmentId(resultSet.getInt("departmentId"));

        return worker;
    }
}
