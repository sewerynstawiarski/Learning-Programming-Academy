package lpa;

import lpa.student.Course;
import lpa.student.Student;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class FileWritingChallenge {
    public static void main(String[] args) {
        Course jmc = new Course("JMC", "Java Masterclass");
        Course pymc = new Course("PYC", "Python Masterclass");
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .toList();

        try(BufferedWriter writer = Files.newBufferedWriter(Path.of("challenge.json"))){
            writer.write("[");
            StringJoiner stringJoiner = new StringJoiner(",");
            for (Student student : students) {
                StringJoiner engagementString = new StringJoiner(",");
                var engagementList = student.getEngagementRecords();
                for (var engagementRecord :
                        engagementList) {
                    String[] data = engagementRecord.split(",");
                    engagementString.add(String.format(
                            " {%n" +
                                    "\t\t\"courseCode\": \"%s\",%n" +
                                    "\t\t\"engagementType\": \"%s\",%n" +
                                    "\t\t\"enrollmentMonth\": %d,%n" +
                                    "\t\t\"enrollmentYear\": %s%n"
                            + "\t}"
                            ,data[7]
                            ,data[10]
                            ,Month.valueOf(data[8]).getValue()
                            ,data[9]


                    ));
                }
                stringJoiner.add(String.format("%n{\t\"studentId\": %d,%n" +
                        "\t\"demographics\": {%n" +
                        "\t\t\"countryCode\": \"%s\",%n" +
                        "\t\t\"enrolledMonth\": %d,%n" +
                        "\t\t\"enrolledYear\": %d,%n"  +
                        "\t\t\"ageAtEnrollment\": %d,%n" +
                        "\t\t\"gender\": \"%s\",%n" +
                        "\t\t\"previousProgrammingExperience\": \"%s\"%n" +
                        "},%n" +
                        "\t\"engagement\": [" +
                        "%s" +
                        "]%n}"

                        ,student.getStudentId()
                        ,student.getCountry()
                        ,student.getEnrollmentMonth()
                        ,student.getEnrollmentYear()
                        , student.getEnrollmentAge()
                        ,student.getGender()
                        ,student.hasExperience() ? "true" : "false"
                        , engagementString

                ));
            }
            writer.write(stringJoiner.toString());
            writer.write("\n]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
