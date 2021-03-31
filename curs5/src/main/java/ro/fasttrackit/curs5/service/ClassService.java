package ro.fasttrackit.curs5.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    private final PersonService service;

    public ClassService(@Qualifier("personService") PersonService service) {
        this.service = service;
        System.out.println("-----" + service.getName());
        System.out.println(service);
        service.setName("this is class service persons");
    }

    public void doSomething() {
        System.out.println("class service: " + service.getName());
    }

    public void doConcurrent() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " using " + service);
        service.setName(threadName + "-personService");
        Thread.yield();
        System.out.println(threadName + " " + service.getName());
    }
}
