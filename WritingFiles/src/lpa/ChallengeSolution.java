package lpa;

import lpa.student.Course;
import lpa.student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChallengeSolution {
    public static void main(String[] args) {
        Course jmc = new Course("JMC", "Java Masterclass");
        Course pymc = new Course("PYC", "Python Masterclass");
        String delimiter = "," + System.lineSeparator();
        String students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .map(Student::toJSON)
                .collect(Collectors.joining(delimiter, "[", "]"));
        System.out.println(students);

        try {
            Files.writeString(Path.of("studentsSolution.json"), students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
