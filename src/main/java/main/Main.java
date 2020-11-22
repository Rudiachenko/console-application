package main;

import console.Application;
import dao.impl.DepartmentDaoImpl;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

public class Main {
    public static void main(String[] args) {
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl(sessionFactory);
        DepartmentService departmentService = new DepartmentServiceImpl(departmentDao);


        Application application = new Application(departmentNameCommand,
                statisticCommand, averageSalaryCommand,
                countOfEmployeeCommand, globalSearchCommand,
                quitCommand, menuCommand);
        application.start();

    }
}
