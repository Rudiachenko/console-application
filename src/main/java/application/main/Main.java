package application.main;

import application.config.AppConfig;
import application.console.Application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import application.service.DepartmentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        DepartmentService departmentService = context.getBean(DepartmentService.class);
        Application application = new Application(departmentService);
        application.start();
    }
}