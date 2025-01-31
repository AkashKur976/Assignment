import java.util.*;
import java.util.regex.*;
import java.sql.*;
import java.io.*;
abstract class Employee{
    protected static void makeEmployee(String designation,String department){
        String name;
        int age;
        float salary;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter Name: ");
            name = br.readLine();

            System.out.print("Enter Age: ");
            age = Integer.parseInt(br.readLine());

            System.out.print("Enter Salary: ");
            salary = Float.parseFloat(br.readLine());
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb","postgres","tiger");
            PreparedStatement pstmt = con.prepareStatement("Insert into employee (name,age,salary,designation,department) values (?,?,?,?,?);");
            pstmt.setString(1,name);
            pstmt.setInt(2,age);
            pstmt.setFloat(3,salary);
            pstmt.setString(4,designation);
            pstmt.setString(5,department);
            pstmt.execute();
            pstmt.close();
            con.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void showAllEmployee(int num){
        try{
            String choice[] = new String[3];
            choice[0] = "eid";
            choice[1] = "Salary";
            choice[2] = "Age";
            String sort = "";
            if(num<3&&num>=0)
                sort = choice[num]; 
            System.out.println("Detailes of Employee\n----------------------------------------");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb","postgres","tiger");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Employee order by "+sort+";");
            while(rs.next()){
                System.out.println("Eid : "+rs.getString(1)+"\nName : "+rs.getString(2)+"\nAge : "+rs.getString(3)
                +"\nSalary : "+rs.getString(4)+"\nDesignation : "+rs.getString(5)+"\nDepartment : "+rs.getString(6));
                System.out.println();
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void removeEmployee(){
        BufferedReader br = null;
        System.out.print("Enter the id you want to remove : ");
        int eid;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            eid = Integer.parseInt(br.readLine());
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb","postgres","tiger");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Employee where eid = "+eid+";");
            rs.next();
            System.out.println("Eid : "+rs.getString(1)+"\nName : "+rs.getString(2)+"\nAge : "+rs.getString(3)
                +"\nSalary : "+rs.getString(4)+"\nDesignation : "+rs.getString(5)+"\nDepartment : "+rs.getString(6));
            System.out.println();
            System.out.println("If this is the Employee you want to delete type Y");
            String yes = br.readLine();
            if(yes.equalsIgnoreCase("y")){
                stmt.executeUpdate("Delete From Employee where eid = "+eid+";");
                System.out.println("Employee is removed");
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void search(){
        BufferedReader br = null;
        System.out.print("Enter the id to search : ");
        int eid;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            eid = Integer.parseInt(br.readLine());
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb","postgres","tiger");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Employee where eid = "+eid+";");
            rs.next();
            System.out.println("Eid : "+rs.getString(1)+"\nName : "+rs.getString(2)+"\nAge : "+rs.getString(3)
                +"\nSalary : "+rs.getString(4)+"\nDesignation : "+rs.getString(5)+"\nDepartment : "+rs.getString(6));
            System.out.println();
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void appraisal(){
        int eid;
        float raise;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter EID to raise the salary : ");
            eid = Integer.parseInt(br.readLine());
            System.out.print("Enter the raise amount : ");
            raise = Float.parseFloat(br.readLine());
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb","postgres","tiger");
            PreparedStatement ptstmt = con.prepareStatement("Update Employee set salary = salary + ? where eid = ?;");
            ptstmt.setFloat(1,raise);
            ptstmt.setInt(2,eid);
            ptstmt.execute();
            ptstmt.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }   
}
class Clerk extends Employee{
    private Clerk(){

    }
    public static void makeClerk(){
        Employee.makeEmployee("Clerk","Helper");
    }
}
class Programmer extends Employee{
    private Programmer(){

    }
    public static void makeProgrammer(){
        Employee.makeEmployee("Programmer","IT");
    }
}
class Manager extends Employee{
    private Manager(){

    }
    public static void makeManager(){
        Employee.makeEmployee("Manager","Managemennt");
    }
}
    

public class EmployeeWithDBMS {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Enter Choice :-");
            System.out.println("-------------");
            System.out.println("1. Create\n2. Display\n3. Appraisal\n4. Remove\n5. Search\n6. Exit");
            System.out.println("-------------");
            int choice1 = 0;
            choice1 = Integer.parseInt(br.readLine());
            if(choice1 == 6)
                break;
            switch (choice1) {
                case 1:
                    int cnt = 0;
                    while (true) {
                        int choice2 = 0;
                        System.out.println("Enter Choice :-");
                        System.out.println("-------------");
                        System.out.println("1. Clerk\n2. Programmer\n3. Manager\n4. Exit");
                        System.out.println("-------------");
                        choice2 = Integer.parseInt(br.readLine());
                        if (choice2 == 4)
                            break;
                        switch (choice2) {
                            case 1:
                                Clerk.makeClerk();
                            case 2:
                                Programmer.makeProgrammer();
                                break;
                            case 3:
                                Manager.makeManager();
                                break;
                            default:
                                System.out.println("Not a Valid Command");
                                break;
                        }
                    }
                    break;
                case 2:
                    Employee.showAllEmployee(2);
                    break;
                case 3:
                    Employee.appraisal();
                    break;
                case 4:
                    Employee.removeEmployee();
                    break;
                case 5:
                    Employee.search();
                    break;
                case 6:
                    
                    System.out.println("Invalid choice");
                    
                    break;
                default:
                    System.out.println("Not a Valid Command");
                    break;
            }
        }
    }
}
