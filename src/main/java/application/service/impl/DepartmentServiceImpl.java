package application.service.impl;

import application.dao.DepartmentDao;
import application.dao.impl.DepartmentDaoImpl;
import application.model.Department;
import application.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.service.DepartmentService;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Employee findTheHeadOfDepartment(String name) {
        Department department = findByName(name);
        return department.getHeadOfDepartment();
    }

    @Override
    public List<Employee> findEmployeesOfDepartment(String name) {
        Department department = findByName(name);
        return department.getEmployees();
    }

    @Override
    public Department addData(Department department) {
        return departmentDao.addData(department);
    }

    @Override
    public Department findByName(String name) {
        return departmentDao.findByName(name);
    }
}
