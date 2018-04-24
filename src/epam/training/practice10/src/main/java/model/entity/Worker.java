package model.entity;

public class Worker {
    private Integer id;
    private String name;
    private String surname;
    private String position;
    private Integer departmentId;

    public Worker(){}

    public Worker(Integer id, String name, String surname, String position, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
