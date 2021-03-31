package ro.fasttrackit.curs5.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs5.config.RecommendedConfig;

@Service
public class OtherService {
    private final RecommendedConfig config;

    public OtherService(RecommendedConfig config) {
        this.config = config;
        System.out.println("from recommended config " + config.getName());
        System.out.println("from recommended config " + config.getTimeout());
    }
}
