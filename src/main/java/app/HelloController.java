package app;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.serde.annotation.Serdeable;

@Controller("/hello")
public class HelloController {

    @Get
    Response index() {
        return new Response("Hello", "World");
    }

    @Serdeable
    record Response(String greeting, String name) {
    }
}
