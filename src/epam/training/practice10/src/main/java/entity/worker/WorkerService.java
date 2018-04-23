package entity.worker;


import database.GenericService;
import database.query.Queries;
import entity.department.Department;
import org.apache.log4j.Logger;
import view.message.LogMessage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerService extends GenericService<Worker>{
    private final static Logger LOGGER = Logger.getLogger(WorkerService.class);

    public WorkerService() {
        super(new WorkerDAO());
    }

    public List<Worker> getAll(){
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_ALL_WORKERS)){

            return dao.select(statement);
        } catch (SQLException e){
            LOGGER.error(LogMessage.PREPARE_STATEMENT_ERROR, e);
        }
        return new ArrayList<>();
    }

    public List<Worker> getWorkersOfDepartment(Department department){
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_WORKERS_OF_DEPARTMENT)){

            statement.setInt(1, department.getId());
            return dao.select(statement);
        } catch (SQLException e){
            LOGGER.error(LogMessage.PREPARE_STATEMENT_ERROR, e);
        }
        return new ArrayList<>();
    }

    public void delete(Worker worker){
        try (PreparedStatement statement = connection.prepareStatement(Queries.DELETE_WORKER)) {

            statement.setInt(1, worker.getId());
            dao.update(statement);
        } catch (SQLException e){
            LOGGER.error(LogMessage.PREPARE_STATEMENT_ERROR, e);
        }
    }
}
