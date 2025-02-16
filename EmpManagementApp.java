package emp.assignment;
import java.util.*;
abstract class Employee{
        static int empCount = 0;
        private int eid;
        private String name;
        private int age;
        private float salary;
        private String designation;
        public Employee(int eid,float salary,String designation){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Name - ");
            String name = sc.next(); 
            System.out.print("Enter the Age - ");
            int age = sc.nextInt(); 
            this.salary = salary;
            this.eid = eid;
            if(age>60 || age<21){
                System.out.println("You have typed a wrong age(default to 21)");
                this.age = 21;
            }
            else{
                this.age = age;
            }
            this.name = name;
            this.designation = designation;
        }
        public void display(){
            System.out.println("Name - "+name);
            System.out.println("Employee ID - "+eid);
            System.out.println("Age - "+age);
            System.out.println("Salary - $"+salary);
            System.out.println("Designation - "+designation);
        }    
        public int getEid(){
            return eid;
        }
        public float getSalary(){
            return this.salary;
        }
        protected void setSalary(float salary){
            this.salary = salary;
        }
        abstract void raiseSalary();
};
final class Clerk extends Employee{
    public Clerk(int eid){
        super(eid,20000,"Clerk");
    }
    void raiseSalary(){
        setSalary(getSalary()+2000);
    }
};

final class Programmer extends Employee{
    public Programmer(int eid){
        super(eid,30000,"Programmer");
    }
    void raiseSalary(){
        setSalary(getSalary()+5000);
    }
};

final class Manager extends Employee{
    public Manager(int eid){
        super(eid,100000,"Manager");
    }
    
    void raiseSalary(){
        setSalary(getSalary()+15000);
    }
};




public class EmpManagementApp{
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        Employee emp[] = new Employee[100];
        while(true){
            System.out.println("Enter Choice :-");
            System.out.println("-------------");
            System.out.println("1. Create\n2. Display\n3. Raise Salary\n4. Remove\n5. Exit");
            System.out.println("-------------");
            int choice1 = sc.nextInt();
            if(choice1==5)
                break;
            switch(choice1){
                case 1:
                {
                    int cnt = 0;
                    while(true){
                        System.out.println("Enter Choice :-");
                        System.out.println("-------------");
                        System.out.println("1. Clerk\n2. Programmer\n3. Manager\n5. Exit");
                        System.out.println("-------------");
                        int choice2 = sc.nextInt();
                        if(choice2==4)
                            break;
                        switch(choice2){
                            case 1:
                            {
                                System.out.println("Enter the Employee ID");
                                int id = sc.nextInt();
                                boolean flag = false;
                                for(int i = 0;i<Employee.empCount;i++){
                                    if(emp[i].getEid() == id){
                                        flag = true;
                                    }
                                }
                                if(flag){
                                    System.out.println("The EID already exists");
                                    break;
                                }

                                Clerk c = new Clerk(id);
                                emp[Employee.empCount] = c;
                                Employee.empCount+=1;
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Enter the Employee ID");
                                int id = sc.nextInt();
                                boolean flag = false;
                                for(int i = 0;i<Employee.empCount;i++){
                                    if(emp[i].getEid() == id){
                                        flag = true;
                                    }
                                }
                                if(flag){
                                    System.out.println("The EID already exists");
                                    break;
                                }

                                Programmer c = new Programmer(id);
                                emp[Employee.empCount] = c;
                                Employee.empCount+=1;
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Enter the Employee ID");
                                int id = sc.nextInt();
                                boolean flag = false;
                                for(int i = 0;i<Employee.empCount;i++){
                                    if(emp[i].getEid() == id){
                                        flag = true;
                                    }
                                }
                                if(flag){
                                    System.out.println("The EID already exists");
                                    break;
                                }

                                Manager c = new Manager(id);
                                emp[Employee.empCount] = c;
                                Employee.empCount+=1;
                                break;
                            }
                            default:
                            {
                                System.out.println("Not a Valid Command");
                                break;
                            }
                        }
                    }
                    System.out.println("Employee Created - "+Employee.empCount);
                    break;
                }
                case 2:
                {
                    if(Employee.empCount==0){
                        System.out.println("No Employee to Show");
                        break;
                    }
                    System.out.println();
                    for(int i = 0;i<Employee.empCount;i++){
                        emp[i].display();
                    }
                    System.out.println();
                    break;
                }
                case 3:
                {
                    for(int i = 0;i<Employee.empCount;i++){
                        emp[i].raiseSalary();
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("Enter the EID to remove");
                    int id = sc.nextInt();
                    int ind = -1;
                    for(int i = 0;i<Employee.empCount;i++){
                        if(emp[i].getEid()==id){
                            ind = i;
                            break;
                        }
                    }
                    if(ind==-1){
                        System.out.println("The Employee does not exist");
                        break;
                    }
                    emp[ind].display();
                    System.out.println("\nTyep Y if you want to delete user Else type N");
                    String ch = sc.next();
                    if(ch.equals("Y")){
                        emp[ind] = emp[Employee.empCount-1];
                        Employee.empCount-=1;
                        System.out.println("That Employee is deleted");
                    }
                    
                }
                default:
                {
                    System.out.println("Not a Valid Command");
                    break;
                }
            }
        }
    }
}