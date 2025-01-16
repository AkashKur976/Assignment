sealed class A permits B{
    private static A a1 = null; 
    A(){    
        try{
            if(this instanceof B && this instanceof A){
                System.out.println("B object created");
            }
            else if(this instanceof A && a1 == null){
                a1 = this;
            }
            else
                throw new DuplicateException("Cannot create duplicate element of this class");
        }
        catch (DuplicateException e){
            System.out.println(e.getMessage());
        }
    } 
    public static A getObject(){
        if(a1 == null)
            a1 = new A();
        return a1;
    }
}
final class B extends A{
    private static B b1 = null;
    private B(){

    }
    public static B getObject(){
        if(b1==null)
            b1 = new B();
        return b1;
    }
}
class DuplicateException extends Exception{
    DuplicateException(){
        super();
    }
    DuplicateException(String msg){
        super(msg);
    }
}
public class SingletonAssignment{
    public static void main(String args[]){
        A a1 = A.getObject();
        A a2 = new A();
        
    }
}