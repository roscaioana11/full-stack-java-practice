package ro.fasttackit.classes.curs3;

import ro.fasttackit.classes.curs3.additional.Person;

public class Java14Features {
    public static void main(String[] args) {
        switchExpression();
        betterNPE();
    }

    private static void betterNPE() {
        Person person = new Person(null, 10, null);
        System.out.println(person.getName().length());
    }

    private static void switchExpression() {
        String choice = "pizza";
        String resultOldSwitch;
        switch (choice) {
            case "pizza":
            case "burger":
                resultOldSwitch = "delicious";
                System.out.println("Delicious");
            case "salad":
                System.out.println("Healthy");
                break;
            default:
                System.out.println("food");
        }

        String result = switch (choice) {
            case "pizza", "burger":
                yield "Delicious";
            default:
                yield "food";
        };
        System.out.println(result);
        System.out.println("fallthrough?");
        String value = switch (choice) {
            case "pizza", "burger":
                System.out.println("Delicious");
            case "salad":
                System.out.println("Healthy choice");
                System.out.println("Healthy choice");
                System.out.println("Healthy choice");
                yield "healthy";
            default:
                yield "food";
        };
        System.out.println(value);

        String newValue = switch (choice) {
            case "pizza", "burger" -> "Delicious";
            case "salad" -> {
                System.out.println("It's greeen!");
                yield "healthy";
            }
            default -> "food";
        };
        System.out.println("new value: " + newValue);
    }
}
