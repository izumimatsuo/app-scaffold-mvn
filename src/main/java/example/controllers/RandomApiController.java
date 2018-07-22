package example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.models.random.Random;
import example.models.random.RandomRepository;
import example.services.ApplicationException;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RandomApiController {

    private final RandomRepository randomRepository;
    
    @RequestMapping("/api/random")
    @ResponseBody
    public Random show() {
        Random random = randomRepository.findValue();
        if (random == null) {
            throw new ApplicationException();
        }
        return random;
    }
}
