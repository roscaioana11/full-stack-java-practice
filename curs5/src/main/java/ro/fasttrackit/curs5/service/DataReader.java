package ro.fasttrackit.curs5.service;

import ro.fasttrackit.curs5.domain.Person;

import java.util.List;

public interface DataReader {
    List<Person> read();

    class FileReader implements DataReader {
        public FileReader() {
            System.out.println("Creating fileReader");
        }

        @Override
        public List<Person> read() {
            return List.of();
        }
    }


    class DbReader implements DataReader {
        public DbReader() {
            System.out.println("Creating dbreader");
        }

        @Override
        public List<Person> read() {
            return List.of();
        }
    }
}

