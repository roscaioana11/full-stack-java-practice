package ro.fasttackit.classes.curs3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
public class Java9Features {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        processApi();
        tryWithResourcesImprovement();
        completableFutureDelayed();
        optionalMethod();
//        Thread.sleep(100000000L);
        streamImprovements();

        httpClient();

    }

    private static void httpClient() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .GET()
                .build();
        Optional.ofNullable(HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body())
                .ifPresent(System.out::println);
    }

    private static void streamImprovements() {
        OptionalDouble average = IntStream.range(1, 100)
                .average();
        System.out.println(average.orElse(0));

        IntStream.iterate(0, i -> i < 3, i -> i + 1)
                .forEach(System.out::println);
        System.out.println("-----");
        System.out.println(
                Stream.of(1, 2, 3, 4)
                        .takeWhile(i -> i < 3)
                        .map(i -> i + " elem")
                        .collect(joining(",")));
    }

    private static void optionalMethod() {
        Optional.ofNullable("a")
                .ifPresentOrElse(
                        value -> System.out.println(value),
                        () -> System.out.println("Doesn't exist"));
    }

    private static void completableFutureDelayed() throws InterruptedException {
        Executor executor = CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS);
        executor.execute(() -> System.out.println("Hello 3 secunde"));
//        Thread.sleep(5000);
    }

    private static void tryWithResourcesImprovement() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/test.txt", true));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("src/main/resources/test2.txt"));
        try (writer; writer2) {
            writer.write("Break compilation");
        }
    }

    private static void processApi() {
        ProcessHandle current = ProcessHandle.current();
        System.out.println(current.info());

        ProcessHandle.of(4047)
                .ifPresent(Java9Features::doSomethingWithProcess);
    }

    private static void doSomethingWithProcess(ProcessHandle processHandle) {
        CompletableFuture<ProcessHandle> async = processHandle.onExit();
        async.thenAccept(smallProcess -> System.out.println("Process " + smallProcess.pid() + " died"));
    }
}

interface DataProvider {

    default String provideData() {
        String name = getName();
        return name + " hello";
    }

    private String getName() {
        return "name";
    }
}

class MySmallProcess {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(ProcessHandle.current().pid());
        Thread.sleep(10000000L);
    }
}
