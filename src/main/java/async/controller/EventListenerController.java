package async.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventListenerController {

    @GetMapping("/event")
    public String event() {
        System.out.println("event");
        return "event";
    }
}
