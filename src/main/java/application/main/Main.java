package application.main;

import application.config.AppConfig;
import application.console.Application;
import application.service.DepartmentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        DepartmentService departmentService = context.getBean(DepartmentService.class);

        DataInjector dataInjector = new DataInjector(departmentService);
        dataInjector.injectData();
        Application application = new Application(departmentService);
        application.start();
    }
}
