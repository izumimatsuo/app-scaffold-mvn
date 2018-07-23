package example.adapters.restoperation;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

import example.models.random.Random;
import example.models.random.RandomRepository;

@Repository
public class RandomRestoperation implements RandomRepository {

    private RestOperations restOperations;
    
    public RandomRestoperation(RestTemplateBuilder restTemplateBuilder) {
        restOperations = restTemplateBuilder.build();
    }

    @Override
    public Random findValue() {
        String url = "http://gturnquist-quoters.cfapps.io/api/random";
        return restOperations.getForObject(url, Random.class);
    }

}
