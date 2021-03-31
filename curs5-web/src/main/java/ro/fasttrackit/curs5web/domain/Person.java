package ro.fasttrackit.curs5web.domain;


import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Person {
    int id;
    String name;
    int age;
}
