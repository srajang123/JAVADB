import java.util.UUID;

public class Student
{
    String name;
    int age;
    UUID id;
    Student(String name,int age){
        this.name=name;
        this.age=age;
        this.id=UUID.randomUUID();
    }
    Student(String id,String name,int age){
        this.name=name;
        this.age=age;
        this.id=UUID.fromString(id);
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
    public String toString(){
        String ret="";
        ret="Id: "+id+"\nName: "+name+"\nAge: "+age+"\n";
        return ret;
    }
}