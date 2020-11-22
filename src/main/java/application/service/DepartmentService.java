package application.service;

import application.model.Department;
import application.model.Employee;

import java.util.List;

public interface DepartmentService {
    Department addData(Department department);

    Employee findTheHeadOfDepartment(String name);

    List<Employee> findEmployeesOfDepartment(String name);

    Department findByName(String name);
}
