package save_student2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        File3 f = new File3();

        List<Student> l = new ArrayList<Student>();
        l.add(new Student(1, "em be", 2002, 10.0));
        l.add(new Student(2, "em be 2", 2002, 9.0));
        l.add(new Student(3, "em be 3", 2002, 9.5));

//		f.save(l, "D:\\WorkSpace\\LTM\\test.txt");

        System.out.println(f.read("D:\\WorkSpace\\LTM\\test.txt", 1));

    }
}
