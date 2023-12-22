import model.LPAStudent;
import model.Student;
import util.QueryList;
import util.StudentIdComparator;
import util.StudentLPAComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int studentCount = 25;
        ArrayList<LPAStudent> students = new ArrayList<>();
        for (int i = 0 ; i< studentCount; i++) {
            students.add(new LPAStudent());
        }


        Comparator<Student> studentIdComparator = new StudentIdComparator();
        students.sort(studentIdComparator);
       Comparator<LPAStudent> lpaComparator = new StudentLPAComparator();
//        students.sort(lpaComparator);
        printMoreLists(students);

        var queryList = new QueryList<>(students);
        var matches =  queryList.getMatches("percentComplete", "50");
       // matches.sort(Comparator.naturalOrder());
        matches.sort(studentIdComparator);
        //matches.sort(lpaComparator);
       printMoreLists(matches);





}
    public static void printMoreLists(List<? extends Student > students) {

        for (var student :
                students) {
            System.out.println(student);
        }
        System.out.println();
    }
}

