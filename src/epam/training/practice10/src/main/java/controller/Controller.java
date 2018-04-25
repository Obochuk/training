package controller;

import model.database.dao.impl.DepartmentDAO;
import model.database.dao.impl.TaskDAO;
import model.database.dao.impl.WorkerDAO;
import model.entity.Department;
import model.entity.Task;
import model.entity.Worker;
import view.IView;
import view.message.ResultMessage;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class Controller {

    private IView view;

    public Controller(IView view) {
        this.view = view;
    }

    public void process(){
        try {
            WorkerDAO workerDAO = WorkerDAO.getInstance();
            List<Worker> workers = workerDAO.getAll();
            view.printMessageAndResult(ResultMessage.ALL_WORKERS, workers);

            TaskDAO taskDAO = TaskDAO.getInstance();
            List<Task> tasks = taskDAO.getAll();
            view.printMessageAndResult(ResultMessage.ALL_TASKS, tasks);

            DepartmentDAO departmentDAO = DepartmentDAO.getInstance();
            List<Department> departments = departmentDAO.getAll();
            Department department = getRandom(departments);
            List<Worker> workersOfDepartment = workerDAO.getWorkersOfDepartment(department);
            view.printMessageAndResult(ResultMessage.WORKERS_OF_DEPARTMENT, workersOfDepartment);

            Worker workerWithNewTask = getRandom(workers);
            Task newTask = new Task(100, "Get out", workerWithNewTask.getId());
            taskDAO.merge(newTask);
            view.printMessageAndResult(ResultMessage.TASK_INSERTED, newTask);

            List<Task> tasksOfWorker = taskDAO.getWorkerTasks(workerWithNewTask);
            view.printMessageAndResult(ResultMessage.TASKS_OF_WORKER, tasksOfWorker);

            workerDAO.delete(workerWithNewTask);
            view.printMessageAndResult(ResultMessage.DELETED_WORKER, workerWithNewTask);

        } catch (SQLException ignored) {}
    }

    private<T> T getRandom(List<T> from) {
        Random rnd = new Random();
        int i = rnd.nextInt(from.size());
        return from.get(i);
    }
}
