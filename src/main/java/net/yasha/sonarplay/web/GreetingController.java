package net.yasha.sonarplay.web;

import java.util.concurrent.atomic.AtomicLong;
import net.yasha.sonarplay.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        String x = null;
        if (name.equalsIgnoreCase("ABC"))
            x = "abc";

        if (x.equalsIgnoreCase("DD"))
            return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }
}