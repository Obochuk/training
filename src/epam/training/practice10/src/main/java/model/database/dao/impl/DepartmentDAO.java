package model.database.dao.impl;

import model.database.dao.GenericDAO;
import model.entity.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements GenericDAO<Department, Integer> {

    private static DepartmentDAO instance;

    private DepartmentDAO(){}

    public static DepartmentDAO getInstance(){
        if (instance == null)
            instance = new DepartmentDAO();
        return instance;
    }

    private interface Query{
        String GET_ALL = "SELECT * FROM departments";
        String GET_BY_ID = "SELECT * FROM departments WHERE id = ?";
        String DELETE = "DELETE FROM departments WHERE id = ?";
        String MERGE = "INSERT INTO departments (id, name, phone) VALUES(?, ?, ?)" +
                "ON DUPLICATE KEY UPDATE name = ?, phone = ?";
        String INSERT = "INSERT INTO departments (name, phone) VALUES(?, ?)";
    }

    @Override
    public List<Department> getAll() throws SQLException {
        Statement statement = CONNECTION.createStatement();
        ResultSet resultSet = statement.executeQuery(Query.GET_ALL);
        List<Department> departments = new ArrayList<>();
        while (resultSet.next()){
            departments.add(retrieveDepartment(resultSet));
        }
        return departments;
    }

    @Override
    public Department getById(Integer id) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.GET_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next())
            return retrieveDepartment(resultSet);
        return null;
    }

    @Override
    public boolean delete(Department elem) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.DELETE);
        statement.setInt(1, elem.getId());

        return statement.execute();
    }

    @Override
    public boolean merge(Department elem) throws SQLException {
        if (elem.getId() == null)
            return insert(elem);

        PreparedStatement statement = CONNECTION.prepareStatement(Query.MERGE);
        statement.setInt(1, elem.getId());
        statement.setString(2, elem.getName());
        statement.setString(3, elem.getPhone());
        statement.setString(4, elem.getName());
        statement.setString(5, elem.getPhone());

        return statement.execute();
    }

    @Override
    public boolean insert(Department elem) throws SQLException {
        PreparedStatement statement = CONNECTION.prepareStatement(Query.INSERT);
        statement.setString(1, elem.getName());
        statement.setString(2, elem.getPhone());

        return statement.execute();
    }

    private Department retrieveDepartment(ResultSet resultSet) throws SQLException{
        Department department = new Department();
        department.setId(resultSet.getInt("id"));
        department.setName(resultSet.getString("name"));
        department.setPhone(resultSet.getString("phone"));
        return department;
    }
}
