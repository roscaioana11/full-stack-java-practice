package ro.fasttrackit.curs5.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
public class JustForTest {
}


@Profile("prod")
@Component
class JustForProduction {

}
