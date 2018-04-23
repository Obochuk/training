package entity.worker;

import database.GenericDAO;
import org.apache.log4j.Logger;
import view.message.LogMessage;

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
            LOGGER.error(LogMessage.SELECT_ERROR, e);
        }
        return workers;
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
