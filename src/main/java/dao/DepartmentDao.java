package dao;

import model.Department;
import model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao {
    Department addData(Department department);

    Department findByName(String name);
}
