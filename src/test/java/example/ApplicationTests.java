package example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void アプリケーションが正常に起動すること() throws Exception {
        Application.main(new String[0]);
        assertTrue(true);
    }
}
