package ro.fasttrackit.curs5.domain;

import org.springframework.stereotype.Component;

@Component("my-qualifier-for-first-bean")
public class FirstBean {
    public FirstBean() {
        System.out.println("I'm creating FirstBean");
    }

    public void hello() {
        System.out.println("hello FirstBean");
    }
}
