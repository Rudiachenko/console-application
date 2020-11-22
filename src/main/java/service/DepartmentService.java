package service;

import model.Department;

public interface DepartmentService {
    Department addData(Department department);
    Department findByName(String name);
}
