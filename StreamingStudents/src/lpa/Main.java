package lpa;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
//        Student tim = new Student("AU", 2019, 30, "M", true, jmc, pymc);
//        System.out.println(tim);
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);

        Student[] students = new Student[1000];
        Arrays.setAll(students, i -> students[i] = Student.getRandomStudent(pymc, jmc));

        var maleStudents = Arrays.stream(students)
                .filter(s -> s.getGender() == "M")
                .count();
        System.out.println("Male Students = " + maleStudents);

        var femaleStudents = Arrays.stream(students)
                .filter(s -> s.getGender() == "F")
                .count();
        System.out.println("Female Students = " + femaleStudents);

        for (String gender : List.of("M", "F")) {
            var myStudents = Arrays.stream(students)
                    .filter(s -> s.getGender().equals(gender));
            System.out.println("# of " + gender + " students " + myStudents.count());
        }

        var under30 = Arrays.stream(students)
                .filter(s -> s.getAge() < 30)
                .count();
        System.out.println("Under 30:  " + under30);

        var over30under60 = Arrays.stream(students)
                .filter(s -> s.getAge() > 30 && s.getAge() < 60)
                .count();
        System.out.println("Under 30 Over 60:  " + over30under60);

        var over60 = Arrays.stream(students)
                .filter(s -> s.getAge() > 60)
                .count();
        System.out.println("Under 30 Over 60:  " + over60);

        List<Predicate<Student>> predicateList = List.of(
                (s) -> s.getAge() < 30,
                (Student s) -> s.getAge() >=30 && s.getAge() <60
        );
        long total = 0;
        for (int i = 0; i < predicateList.size(); i++) {
            var myStudents = Arrays.stream(students).filter(predicateList.get(i));
            long cnt = myStudents.count();
            total += cnt;
            System.out.printf("# of students (%s) = %d%n",
                    i == 0 ? " < 30" : " >30 & < 60", cnt);
        }
        System.out.println("# of students >= 60 " + (students.length - total));

        var ageSummaryStatistics = Arrays.stream(students)
                .mapToInt(Student::getAge)
                .summaryStatistics();
        System.out.println("Summary Statistics:  " + ageSummaryStatistics);

        var countries = Arrays.stream(students)
                .map(Student::getCountryCode)
                        .distinct()
                .sorted()
                                .toList();
        System.out.println("Countries:  " + countries);

//        var moreThan7Years =
                var longTimeLearners =  Arrays.stream(students)
//                .mapToInt(Student::getYearsSinceEnrolled)
                .filter(s -> s.getYearsSinceEnrolled() > 7 && s.getMonthsSinceActive() < 12)
                        .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                        .toList()
                        .toArray(Student[]::new);
//                .forEach(System.out::println);

        //                                .anyMatch(s -> s > 7);
//        System.out.println("More than 7 years exists:  " + moreThan7Years);

                var longTerm = Arrays.stream(students)
                        .filter(s -> s.getYearsSinceEnrolled() > 7 && s.getMonthsSinceActive() < 12)
                        .count();
        System.out.println("Number of long term: " + longTerm);

        var learners =  Arrays.stream(students)
                .filter(s -> s.getYearsSinceEnrolled() > 7 && s.getMonthsSinceActive() < 12)
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .collect(Collectors.toList());

        Collections.shuffle(learners);

    }
}
