package ro.fasttackit.classes.curs3;

public class Java13Features {
    public static void main(String[] args) {
        textBlocks();
    }

    private static void textBlocks() {
        String jsonMultiline = "{" +
                "\"name\":'Ana'," +
                "'age':22" +
                "}";
        String name = "Ana";
        String json = """
                    {
                        "name":"%s",
                        "age": %d    
                    }
                """.formatted(name, 22);

        System.out.println(jsonMultiline);
        System.out.println(json);
    }
}
