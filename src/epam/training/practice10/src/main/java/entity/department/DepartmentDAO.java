package entity.department;

import database.GenericDAO;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends GenericDAO<Department> {
    private final static Logger LOGGER = Logger.getLogger(DepartmentDAO.class);

    @Override
    public List<Department> select(PreparedStatement statement) {
        List<Department> departments = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Department department = new Department();
                department.setId(getFiled(result::getInt, "int"));
                department.setPhone(getFiled(result::getString, "phone"));
                department.setName(getFiled(result::getString, "name"));
                departments.add(department);
            }
        } catch (SQLException e){
            LOGGER.error("Error executing select query", e);
        }
        return departments;
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
