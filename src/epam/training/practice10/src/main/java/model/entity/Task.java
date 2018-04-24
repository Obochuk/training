package model.entity;

public class Task {
    private Integer id;
    private String description;
    private Integer workerId;

    public Task(){}

    public Task(Integer id, String description, Integer workerId) {
        this.id = id;
        this.description = description;
        this.workerId = workerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", workerId=" + workerId +
                '}';
    }
}
