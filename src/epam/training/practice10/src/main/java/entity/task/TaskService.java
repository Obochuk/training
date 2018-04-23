package entity.task;

import database.GenericService;

public class TaskService extends GenericService<Task>{
    public TaskService() {
        super(new TaskDAO());
    }
}
