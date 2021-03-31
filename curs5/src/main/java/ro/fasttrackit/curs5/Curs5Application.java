package ro.fasttrackit.curs5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs5.domain.FirstBean;
import ro.fasttrackit.curs5.service.ClassService;
import ro.fasttrackit.curs5.service.DataReader;
import ro.fasttrackit.curs5.service.DataReader.DbReader;
import ro.fasttrackit.curs5.service.DataReader.FileReader;
import ro.fasttrackit.curs5.service.PersonService;
import ro.fasttrackit.curs5.service.SchoolService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class Curs5Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs5Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(ApplicationContext ctx, ClassService classService, SchoolService schoolService) {
        return args -> {
            Stream.of(ctx.getBeanDefinitionNames())
                    .forEach(System.out::println);
            classService.doSomething();
            schoolService.doSomething();

            concurrentAccess(ctx);
        };
    }

    private void concurrentAccess(ApplicationContext ctx) {
        System.out.println("--------concurent");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            executorService.invokeAll(IntStream.range(1, 20)
                    .mapToObj(index -> (Callable<Object>) () -> {
                        PersonService bean = ctx.getBean("personService", PersonService.class);
                        System.out.println(Thread.currentThread().getName() + " personService instance: " + bean);
                        return null;
                    })
                    .collect(Collectors.toList()));
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Bean
    DataReader fileReader() {
        return new FileReader();
    }

    @Bean("my-qualifier-for-db-reader")
    DataReader dbReaderulMeu() {
        return new DbReader();
    }

    @Bean
    PersonService personServiceManual(FirstBean bean) {
        return new PersonService(bean, "al-meu");
    }

}


