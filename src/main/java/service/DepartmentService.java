package service;

import model.Department;
import model.Employee;

import java.util.List;

public interface DepartmentService {
    Department addData(Department department);

    Employee findTheHeadOfDepartment(String name);

    List<Employee> findEmployeesOfDepartment(String name);

    Department findByName(String name);
}
