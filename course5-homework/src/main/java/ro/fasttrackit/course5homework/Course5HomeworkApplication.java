package ro.fasttrackit.course5homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import ro.fasttrackit.course5homework.domain.Country;
import ro.fasttrackit.course5homework.service.CountryReader;
import ro.fasttrackit.course5homework.service.MyCountryBean;

import java.util.Optional;

@SpringBootApplication
public class Course5HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(Course5HomeworkApplication.class, args);
	}

}
