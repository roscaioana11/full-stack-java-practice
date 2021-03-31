package ro.fasttrackit.curs5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs5.domain.FirstBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope
public class PersonService {
    private final FirstBean firstBean;
    private String name;

    @Autowired
    public PersonService(FirstBean firstBean) {
        this(firstBean, "from-spring");
    }

    public PersonService(FirstBean firstBean, String name) {
        System.out.println("with args");
        this.firstBean = firstBean;
        this.name = name;
    }

    @PostConstruct
    void afterConstruction() {
        System.out.println("------------- after all");
    }

    @PreDestroy
    void beforeDestruction() {
        System.out.println("------------ before destroying request or custom scoped");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getPersons() {
        firstBean.hello();
    }

    public String getName() {
        return name;
    }
}
