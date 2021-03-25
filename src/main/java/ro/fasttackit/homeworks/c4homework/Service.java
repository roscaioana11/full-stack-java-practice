package ro.fasttackit.homeworks.c4homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.*;

public class Service {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }

    public String teeingCollectors(){
        return students.stream()
                .collect(teeing(
                        mapping(student -> student.name() + ", ", joining()),
                        averagingDouble(student -> student.grade()),
                        (nameList, averageGrade) -> nameList + "have an average grade of: " + averageGrade
                ));
    }

    public void textBlocks() {
        List<String> courses = List.of(
                "{\"name\":\"math\",\"semester\":2}",
                "{\"name\":\"biology\",\"semester\":1}",
                "{\"name\":\"medicine\",\"semester\":2}");
        Random random = new Random();

        students.stream()
                .map(student -> student.name() +
                        " will participate to course " +
                        courses.get(random.nextInt(courses.size())))
                .forEach(message -> System.out.println(message));
    }
}
