package ro.fasttackit.classes.curs3;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class Java10Features {
    public static void main(String[] args) {
        localTypeInference();
        copyOfCollections();
    }

    private static void copyOfCollections() {
        List<String> firstCollection = List.of("collector");
        List<String> collector = firstCollection
                .stream()
                .collect(toList());
        collector
                .add("new");
        System.out.println(firstCollection);
        System.out.println(collector);
        List.copyOf(collector);
    }

    private static void localTypeInference() {
        int a = 1;
        var b = 2;

        var map = Map.of(
                "a", Map.of("b", List.of(10))
        );

        String abc = String.valueOf("abc");

        var var = 2;
        int c = 3, d = 4;

        int[] arr = {1, 2, 3, 4};
        int arr2[] = {1, 2, 3, 4, 5};
        var bc = new int[2]; //var = int[]
        var arrInit = new int[]{1, 2, 3, 4};

        Function<String, String> logic = s -> "hello " + s;

        var hack = new MyInterface() {
            int myField = 2;

            @Override
            public String sayHello(String name) {
                return "hello";
            }

            public String myImplementaion() {
                return "my implementation";
            }
        };
        System.out.println(hack.getClass());
        System.out.println(hack.myField);
        System.out.println(hack.myImplementaion());
    }
}
