package codes.recursive;

import io.micronaut.runtime.Micronaut;

import java.util.TimeZone;

public class Application {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
        Micronaut.run(Application.class, args);
    }
}
