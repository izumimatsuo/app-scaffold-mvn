package example.controllers.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.models.random.Random;
import example.services.RandomService;

@RestController
public class RandomApiController {

    @Autowired
    private RandomService randomService;

    @RequestMapping("/api/random")
    public Random show() {
        return randomService.findValue();
    }
}
