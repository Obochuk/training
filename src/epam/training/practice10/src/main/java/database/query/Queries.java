package database.query;

public interface Queries {
    String GET_ALL_WORKERS = "SELECT * FROM workers";
    String GET_ALL_TASKS = "SELECT * FROM tasks";
    String GET_WORKERS_OF_DEPARTMENT = "SELECT * FROM workers WHERE departmentId=?";
    String INSERT_TASK_FOR_WORKER = "INSERT INTO tasks (description, workerID) VALUES(?, ?)";
    String GET_TASKS_FOR_WORKER = "SELECT * FROM tasks WHERE userId=?";
    String DELETE_WORKER = "DELETE FROM workers WHERE id=?";
}
