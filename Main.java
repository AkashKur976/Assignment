abstract class Employee{
        private String name;
        private int age;
        private float salary;
        private String designation;

        public Employee( String name,int age,float salary,String designation){
            this.salary = salary;
            if(age<=0){
                System.out.println("You have typed a wrong age(default to 0)");
            }
            else{
                this.age = age;
            }
            this.name = name;
            this.designation = designation;
        }
        public void display(){
            System.out.println("Name - "+name);
            System.out.println("Age - "+age);
            System.out.println("Salary - $"+salary);
            System.out.println("Designation - "+designation);
        }
        public void raise_Salary(float raise){
            this.salary += raise;
        }
        
};
class Clerk extends Employee{
    public Clerk(String name,int age,float salary){
        super(name,age,salary,"Clerk");
    }
};

class Programmer extends Employee{
    public Programmer(String name,int age,float salary){
        super(name,age,salary,"Programmer");
    }
};

class Manager extends Employee{
    public Manager(String name,int age,float salary){
        super(name,age,salary,"Manager");
    }
    
};
class Main{
    public static void main (String args[]){
        Manager c  = new Manager("Yash",-19,10000);
        c.display();
        c.raise_S   alary(10000);
    }
}