package ro.fasttrackit.course5homework.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ro.fasttrackit.course5homework.domain.Country;

import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyCountryBean {
    private final CountryReader countryReader;

    public MyCountryBean(CountryReader countryReader) {
        this.countryReader = countryReader;
    }

    public Optional<Country> myCountry(String countryName){
        return countryReader.getCountries()
                .stream()
                .filter(country -> country.getName().equals(countryName))
                .findFirst();
    }
}
