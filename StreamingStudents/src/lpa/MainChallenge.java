package lpa;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

        var students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(5000);
        var studentsAverages =   students.map(s -> s.getPercentComplete("JMC"))
                .reduce(0.0, Double::sum);

        double averageForAll = studentsAverages / 5000;
        System.out.println("Average is  = " + averageForAll);

        Stream.generate(() -> Student.getRandomStudent(pymc, jmc, cgj))
                .limit(5000)
                .filter(s -> s.getPercentComplete("JMC") >= (averageForAll*1.25))
        .sorted(Comparator.comparing(Student::getYearsSinceEnrolled).reversed())
                .limit(10)
                .peek(System.out::println)
                .forEach(s -> s.addCourse(new Course("TRI", "Trial Course")));


        List<Student> studentsSol = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        double totalPercent = studentsSol.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
//                .reduce(0, Double::sum);
                .sum();

        double avePercent = totalPercent / studentsSol.size();
        System.out.printf("Average Percentage Complete = %.2f%% %n", avePercent);

        int topPercent = (int) (1.25 + avePercent);

        Comparator<Student> longTermStudents = Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardWorkers = studentsSol.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudents)
                .limit(10)
                .toList();

        hardWorkers.forEach(s -> {
            s.addCourse(cgj);
            System.out.print(s.getStudentId() + " ");
        });

        System.out.println();

        Comparator<Student>  uniqueSorted = longTermStudents.thenComparing(Student::getStudentId);
         studentsSol.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudents)
                .limit(10)
//                .toList()
//                 .collect(Collectors.toList())
//                 .collect(Collectors.toSet())
//                 .collect(() -> new TreeSet<>(uniqueSorted),
//                         TreeSet::add, TreeSet::addAll)
                 .forEach(s -> {
            s.addCourse(cgj);
            System.out.print(s.getStudentId() + " ");
        });
    }
}
