import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    abstract int calculateSalary();
}

class FullTimeEmployee extends Employee {
    private int salary;

    FullTimeEmployee(String name, int id, int salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    public int calculateSalary() {
        return salary;
    }

    public void changeSalary(int newSalary){
        this.salary = newSalary;
    }
}

class PartTimeEmployee extends Employee {
    private int payPerHour;
    private int hoursWorked;

    PartTimeEmployee(String name, int id, int payPerHour, int hoursWorked) {
        super(name, id);
        this.payPerHour = payPerHour;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public int calculateSalary() {
        return payPerHour * hoursWorked;
    }

    public void changePayPerHour(int newPayPerHour){
        this.payPerHour = newPayPerHour;
    }

    public void changeHoursWorked(int newHoursWorked){
        this.hoursWorked = newHoursWorked;
    }
}

class PayRollSystem{
    private ArrayList<Employee> employeeList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void addNewEmployee(){
        System.out.println("What type of employee you want to add?");
        System.out.println("1. Part Time");
        System.out.println("2. Full Time");
        System.out.println("3. Exit");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice==1){
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter pay per hour: ");
            int payperhour = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter hours worked: ");
            int hoursworked = sc.nextInt();
            sc.nextLine();

            PartTimeEmployee ps = new PartTimeEmployee(name,id,payperhour,hoursworked);
            addEmployee(ps);
            System.out.println("Employee Added Successfully!\n");
        }

        else if(choice==2){
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter salary: ");
            int salary = sc.nextInt();
            sc.nextLine();

            FullTimeEmployee fs = new FullTimeEmployee(name,id,salary);
            addEmployee(fs);
            System.out.println("Employee Added Successfully!\n");
        }

        else if(choice==3){
            System.out.println("Exiting...\n");
        }

        else{
            System.out.println("Invalid Choice! Exiting...\n");
        }
    }

    public void removeEmployee(int id){
        for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeeList.remove(employee);
                return;
            }
        }
        System.out.println("Employee not found!\n");
    }

    public void removeAnEmployee(){
        System.out.print("Type the ID of the employee you want to remove: ");
        int id = sc.nextInt();
        sc.nextLine();

        removeEmployee(id);
        System.out.println("Removed Successfully!\n");
    }

    public void displayEmployees(){
        for(Employee employee: employeeList){
            System.out.println("Name:"+employee.getName());
            System.out.println("Salary:"+employee.calculateSalary());
            System.out.println("ID:"+employee.getId()+"\n");
        }
    }

    public void checkSalary(){
        System.out.print("Type the employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        int flag = 0;

        for(Employee employee: employeeList){
            if(employee.getId()==id) {
                System.out.println("Total Salary: " + employee.calculateSalary()+"\n");
                flag = 1;
            }
        }
        if(flag==0){
            System.out.println("Employee don't exits!\n");
        }
    }

    public void editPartTime(PartTimeEmployee ps, int newPayPerHour, int newHoursWorked){
        ps.changePayPerHour(newPayPerHour);
        ps.changeHoursWorked(newHoursWorked);
        System.out.println("Changed Successfully!\n");
    }

    public void editFullTime(FullTimeEmployee fs, int newsalary){
        fs.changeSalary(newsalary);
        System.out.println("Changed Successfully!\n");
    }

    public void editEmployee(){
        System.out.println("What type of employee you want to edit?");
        System.out.println("1. Part Time");
        System.out.println("2. Full Time");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice==1){
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            PartTimeEmployee ps = null;
            int flag = 0;
            for(Employee employee: employeeList){
                if(employee.getId()==id){
                    ps = (PartTimeEmployee) employee;

                    System.out.print("Enter new pay per hour: ");
                    int payperhour = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new hours worked: ");
                    int newhoursworked = sc.nextInt();
                    sc.nextLine();

                    editPartTime(ps,payperhour,newhoursworked);
                    flag = 1;
                }
            }
            if(flag==0){
                System.out.println("Employee not found!\n");
            }
        }

        else if(choice==2){
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            FullTimeEmployee fs = null;
            int flag = 0;
            for(Employee employee: employeeList){
                if(employee.getId()==id){
                    fs = (FullTimeEmployee) employee;

                    System.out.print("Enter new salary: ");
                    int newsalary = sc.nextInt();
                    sc.nextLine();

                    editFullTime(fs,newsalary);
                    flag = 1;
                }
            }
            if(flag==0){
                System.out.println("Employee not found!\n");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayRollSystem ps = new PayRollSystem();
        FullTimeEmployee ft1 = new FullTimeEmployee("John Doe", 45, 10000);
        FullTimeEmployee ft2 = new FullTimeEmployee("Sarah Smith", 40, 15000);
        FullTimeEmployee ft3 = new FullTimeEmployee("Michael Green", 38, 12000);

        PartTimeEmployee pt1 = new PartTimeEmployee("Len Henry", 48, 200, 10);
        PartTimeEmployee pt2 = new PartTimeEmployee("Mark Davis", 25, 150, 15);
        PartTimeEmployee pt3 = new PartTimeEmployee("Olivia Brown", 30, 175, 12);

        ps.addEmployee(ft1);
        ps.addEmployee(ft2);
        ps.addEmployee(ft3);
        ps.addEmployee(pt1);
        ps.addEmployee(pt2);
        ps.addEmployee(pt3);

        Scanner sc = new Scanner(System.in);
        int choice;

        while(true){
            System.out.println("--Welcome to Employee Payroll System--");
            System.out.println("Select your desired option below\n");

            System.out.println("1. Register new employee");
            System.out.println("2. Remove an employee");
            System.out.println("3. View all employees");
            System.out.println("4. Check employee salary");
            System.out.println("5. Edit employee salary");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    ps.addNewEmployee();
                    break;
                case 2:
                    ps.removeAnEmployee();
                    break;
                case 3:
                    ps.displayEmployees();
                    break;
                case 4:
                    ps.checkSalary();
                    break;
                case 5:
                    ps.editEmployee();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid!");
                    break;
            }
        }
    }
}