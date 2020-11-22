package application.dao.impl;

import application.dao.DepartmentDao;
import application.exceptions.DataProcessingException;
import application.model.Department;
import application.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    private final SessionFactory sessionFactory;

    public DepartmentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Department addData(Department department) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            return department;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert cinema hall "
                    + department.toString(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Department findByName(String name) {
        List<Department> departments = new ArrayList<>();
        Employee bob = new Employee();
        bob.setName("bob");
        bob.setLastName("bobinsky");
        bob.setSalary(500d);
        bob.setTitle(Employee.Title.PROFESSOR);

        Department department = new Department();
        department.setName("politology");
        department.setEmployees(List.of(bob));
        department.setHeadOfDepartment(bob);
        departments = List.of(department);

        for (Department departmen : departments){
            if (departmen.getName().equals(name)){
                return departmen;
            }
        }
        throw new NoSuchElementException();
    }
}
