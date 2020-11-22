package service.impl;

import dao.DepartmentDao;
import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
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
