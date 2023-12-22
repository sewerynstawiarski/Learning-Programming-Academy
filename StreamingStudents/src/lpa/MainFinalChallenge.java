package lpa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;

public class MainFinalChallenge {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

        List<Student> students = IntStream
                .rangeClosed(1, 10000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc, cgj))
                .filter(s -> s.getYearsSinceEnrolled() <= 4)
                .toList();


        var numberOfStudentsPython = students.stream()
                .filter(s -> s.getEngagementMap().containsKey("PYMC"))
                .count();
        System.out.println("Python Masterclass: " + numberOfStudentsPython);
        var numberOfStudentsJava = students.stream()
                .filter(s -> s.getEngagementMap().containsKey("JMC"))
                .count();
        System.out.println("Java Masterclass: " + numberOfStudentsJava);
        var numberOfStudentsJavaGames = students.stream()
                .filter(s -> s.getEngagementMap().containsKey("CGJ"))
                .count();
        System.out.println("Java Games Masterclass: " + numberOfStudentsJavaGames);

        var StudentsOneClass =  students.stream()
                .collect(groupingBy(Student::getEngagementMap))
                .keySet()
                 .stream()
                 .filter(map -> map.size() == 1)
                 .count();

        System.out.println("Students with one class = " + StudentsOneClass);
        var StudentsTwoClass =  students.stream()
                .collect(groupingBy(Student::getEngagementMap))
                .keySet()
                .stream()
                .filter(map -> map.size() == 2)
                .count();

        System.out.println("Students with two class = " + StudentsTwoClass);
        var StudentsThreeClass =  students.stream()
                .collect(groupingBy(Student::getEngagementMap))
                .keySet()
                .stream()
                .filter(map -> map.size() == 3)
                .count();

        System.out.println("Students with three class = " + StudentsThreeClass);

    var averagePercentageCompleteForJaVa = students.stream()
            .collect(Collectors.averagingDouble(s ->  s.getPercentComplete("JMC")));

        System.out.printf("Average for JMC: %.2f%%%n", averagePercentageCompleteForJaVa);

        var averagePercentageCompleteForPython = students.stream()
                .collect(Collectors.averagingDouble(s ->  s.getPercentComplete("PYMC")));

        System.out.printf("Average for PYMC: %.2f%%%n", averagePercentageCompleteForPython);


        var averagePercentageCompleteForJAvaGames = students.stream()
                .collect(Collectors.averagingDouble(s ->  s.getPercentComplete("CGJ")));

        System.out.printf("Average for CGJ: %.2f%%%n", averagePercentageCompleteForJAvaGames);


            students.stream()
                .map(s -> s.getEngagementMap().values())
                .flatMap(s -> s.stream())
                 .filter(c -> c.getCourseCode().equals("JMC"))
                .collect(groupingBy(CourseEngagement::getLastActivityYear, HashMap::new, mapping(CourseEngagement::getCourseCode, toList())))
          .forEach((k ,v) -> {
              System.out.println("JMC:");
              System.out.printf("%d: %d%n", k, v.size());
          });
        students.stream()
                .map(s -> s.getEngagementMap().values())
                .flatMap(s -> s.stream())
                .filter(c -> c.getCourseCode().equals("PYMC"))
                .collect(groupingBy(CourseEngagement::getLastActivityYear, HashMap::new, mapping(CourseEngagement::getCourseCode, toList())))
                .forEach((k ,v) -> {
                    System.out.println("PYMC:");
                    System.out.printf("%d: %d%n", k, v.size());
                });
        students.stream()
                .map(s -> s.getEngagementMap().values())
                .flatMap(s -> s.stream())
                .filter(c -> c.getCourseCode().equals("CGJ"))
                .collect(groupingBy(CourseEngagement::getLastActivityYear, HashMap::new, mapping(CourseEngagement::getCourseCode, toList())))
                .forEach((k ,v) -> {
                    System.out.println("CGJ:");
                    System.out.printf("%d: %d%n", k, v.size());
                });

    }
}
