package application.console.answer;

import application.console.Application;
import application.console.ConsoleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import application.service.DepartmentService;

@Component
public class MenuCommand implements ConsoleHandler {
    private DepartmentService departmentService;

    @Autowired
    public MenuCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handleCommand() {
        new Application(departmentService).start();
    }
}
