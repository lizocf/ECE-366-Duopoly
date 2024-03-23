package game;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@SpringBootApplication
@RestController
public class SpringBootTest {
    @CrossOrigin
    @GetMapping("/helloWorld")
    public String helloWorld() {
        System.out.println("HELLO WORLD");
        return "Hello WorldOMGCROSSWORKS";

    }
}

