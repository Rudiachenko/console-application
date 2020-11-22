package console.answer;

import console.ConsoleHandler;
import model.Employee;
import org.springframework.stereotype.Component;
import service.DepartmentService;

import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class DepartmentNameCommand implements ConsoleHandler {
    private DepartmentService departmentService;

    public DepartmentNameCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handleCommand() {
        System.out.println("Please specify the name of the department or print 'menu' to back to menu");
        Scanner scanner = new Scanner(System.in);
        String nameOfDepartment = scanner.nextLine();
        if (nameOfDepartment.equalsIgnoreCase("menu")){
            return;
        }
        try {
            Employee theHeadOfDepartment = departmentService.findTheHeadOfDepartment(nameOfDepartment);
            String answer = " " + "Head of " + nameOfDepartment +
                    " department is " +
                    theHeadOfDepartment.getName() + " " +
                    theHeadOfDepartment.getLastName();
            System.out.println(answer);
        }
        catch (NoSuchElementException e){
            System.out.println("No departments with name " + nameOfDepartment + " was found."
                    + "Please try again.");
            handleCommand();
        }
    }
}
