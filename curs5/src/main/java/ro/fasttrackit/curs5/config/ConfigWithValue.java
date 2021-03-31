package ro.fasttrackit.curs5.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigWithValue {
    //NOT RECOMMENDED
    public ConfigWithValue(@Value("${app.name}") String name) {
        System.out.println("the name from config is " + name);
    }
}
