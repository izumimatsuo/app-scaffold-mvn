package example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.models.random.Random;
import example.models.random.RandomRepository;

@Service
public class RandomService {

    @Autowired
    private RandomRepository randomRepository;

    public Random findValue() {
        Random random = randomRepository.findValue();
        if (random == null) {
            throw new ApplicationException();
        }
        return random;
    }
}
