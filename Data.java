import java.util.ArrayList;
import java.util.List;

public class Data{
    List<Student>studList=new ArrayList<>();
    void insert(Student student){
        studList.add(student);
    }
    List<Student> getList(){
        return studList;
    }
}