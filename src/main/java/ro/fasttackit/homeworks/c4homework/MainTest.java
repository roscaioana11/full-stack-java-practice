package ro.fasttackit.homeworks.c4homework;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class MainTest {
    public static void main(String[] args) {
        Service service = new Service();
        service.addStudent(new Student("Ioana",LocalDate.of(1995, 9, 11), 7));
        service.addStudent(new Student("Adriana",LocalDate.of(1972, 10, 26), 10));
        service.addStudent(new Student("Pop",LocalDate.of(1998, 4, 1), 4.5));
        service.addStudent(new Student("Daniela",LocalDate.of(1990, 7, 30), 8.5));
        service.addStudent(new Student("Mihai",LocalDate.of(1981, 1, 31), 6));

        System.out.println(service.teeingCollectors());

        service.textBlocks();

        StudentEventDispatcher dispatcher = new StudentEventDispatcher();
        IntStream.range(0, service.getStudents().size())
                .forEach(index -> System.out.println(dispatcher.dispatch(index)));
    }
}
