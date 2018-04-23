package entity.worker;


import database.GenericService;

public class WorkerService extends GenericService<Worker>{
    public WorkerService() {
        super(new WorkerDAO());
    }
}
