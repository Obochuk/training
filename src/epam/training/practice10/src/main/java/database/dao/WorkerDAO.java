package database.dao;

import entity.Worker;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO extends GenericDAO<Worker> {
    private final static Logger LOGGER = Logger.getLogger(WorkerDAO.class);

    @Override
    public List<Worker> select(PreparedStatement statement) {
        List<Worker> workers = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Worker worker = new Worker();
                worker.setId(getFiled(result::getInt, "id"));
                worker.setDepartmentId(getFiled(result::getInt, "departmentId"));
                worker.setName(getFiled(result::getString, "name"));
                worker.setPosition(getFiled(result::getString, "position"));
                worker.setSurname(getFiled(result::getString, "surname"));
            }
        } catch (SQLException e){
            LOGGER.error("Error executing select query", e);
        }
        return workers;
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
