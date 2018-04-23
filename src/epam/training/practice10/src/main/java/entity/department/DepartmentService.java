package entity.department;

import database.GenericService;

public class DepartmentService extends GenericService<Department>{

    public DepartmentService(){
        super(new DepartmentDAO());
    }

}
