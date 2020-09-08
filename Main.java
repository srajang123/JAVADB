import java.util.Scanner;
import java.util.UUID;
import java.sql.*;
public class Main{
    static Scanner sc=new Scanner(System.in);
    static Connection con;
    static PreparedStatement smt;
    static ResultSet re;
    public static void insert() throws SQLException{
        String name;
        int age;
        System.out.print("Enter name:\t");
        sc.nextLine();
        name=sc.nextLine();
        System.out.print("enter age:\t");
        age=sc.nextInt();
        smt=con.prepareStatement("insert into data values(?,?,?)");
        smt.setString(1,UUID.randomUUID().toString());
        smt.setString(2,name);
        smt.setInt(3,age);
        smt.executeUpdate();
    }
    public static void display() throws SQLException{
        Data dt=new Data();
        smt=con.prepareStatement("select * from data");
        re=smt.executeQuery();
        while(re.next())
        {
            String id=re.getString(1);
            String name=re.getString(2);
            int age=re.getInt(3);
            if(id.equals("1"))continue;
            dt.insert(new Student(id,name,age));
        }
        for(Student st:dt.getList())
        {
            System.out.println(st);
        }
    }
    public static void main(String[] args)
    {
        int c=1;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?characterEncoding=utf8","srajan","Project@123");
            while(c!=0)
            {
                System.out.println("1. Insert");
                System.out.println("2. Display");
                System.out.println("3. Delete");
                System.out.println("4. Update");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                c=sc.nextInt();
                switch(c)
                {
                    case 0: break;
                    case 1: insert();
                            break;
                    case 2: display();
                            break;
                    default: System.out.println("Wrong choice. try again");
                }
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Database Error: "+e);
        }
    }
}