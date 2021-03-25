package ro.fasttackit.classes.curs3;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

import static java.lang.System.lineSeparator;
import static java.nio.file.StandardOpenOption.APPEND;

public class Java11Features {
    public static void main(String[] args) {
        stringMethods();
        lambdaAnnotations();
        lambdaAnnotations();
        fileMethods();
    }

    private static void fileMethods() {
        try {
            Path of = Path.of("simple.txt");
            Files.writeString(of, "My line" + lineSeparator(), APPEND);
            System.out.println(Files.readString(of));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void lambdaAnnotations() {
        int age = 32; //aloca 32 biti
        useFunction(a -> a + "test");
        age++;
    }

    private static void useFunction(Function<String, String> test) {
        test.apply("");
    }

    private static void stringMethods() {
        String value = "   ";
        System.out.println(value.isBlank());
        System.out.println(value.isEmpty());

        String text = "java ";
        System.out.println(text.repeat(10));
        String unicode = "    \u0000 \u00D8  java   ";
        System.out.println(unicode.trim());
        System.out.println(unicode.strip());
        System.out.println(unicode.stripIndent() + "|");
        System.out.println(unicode.stripTrailing() + "|");
        System.out.println(unicode.stripLeading() + "|");
    }
}
