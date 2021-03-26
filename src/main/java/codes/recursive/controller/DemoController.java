package codes.recursive.controller;

import codes.recursive.Demo2Client;
import codes.recursive.FavoriteNumber;
import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.tracing.annotation.SpanTag;

import java.util.List;

@Controller("/demo1")
public class DemoController {

    private final Demo2Client demo2Client;

    public DemoController(Demo2Client demo2Client) {
        this.demo2Client = demo2Client;
    }

    @Get(uri = "/", produces = "text/plain")
    public String index() {
        return "Example Response";
    }

    @Get(uri = "/user/{id}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse user(@SpanTag("user.id") int id) {
        List<String> users = List.of(
                "Todd", "Graeme", "Thomas", "Oleg", "Gerald",
                "Andres", "Jenn", "Michael", "Phil", "Aaron");
        if (id < 1 || id > users.size()) {
            return HttpResponse.notFound();
        } else {
            String user = users.get(id-1);
            FavoriteNumber favoriteNumber = demo2Client.favoriteNumber(id).blockingFirst();
            return HttpResponse.ok(
                    CollectionUtils.mapOf("username", user, "userId", String.valueOf(id), "favoriteNumber", String.valueOf(favoriteNumber.getFavoriteNumber()))
            );
        }
    }

    @Get(uri = "/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(3500);
        return "slow";
    }

    @Get(uri = "/error")
    public String error() throws Exception {
        throw new Exception("This is an error!");
    }

    @Get(uri = "/unauthorized")
    public HttpResponse unauthorized() {
        return HttpResponse.unauthorized();
    }

    @Get(uri = "/notfound")
    public HttpResponse notfound() {
        return HttpResponse.notFound();
    }
}