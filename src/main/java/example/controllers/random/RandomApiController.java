package example.controllers.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.models.random.Random;
import example.models.random.RandomRepository;
import example.services.ApplicationException;

@RestController
public class RandomApiController {

    @Autowired
    private RandomRepository randomRepository;

    @RequestMapping("/api/random")
    public Random show() {
        Random random = randomRepository.findValue();
        if (random == null) {
            throw new ApplicationException();
        }
        return random;
    }
}
