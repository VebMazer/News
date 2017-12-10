package wad;

import javax.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Transactional
@SpringBootApplication
public class NewzApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewzApplication.class, args);
    }
    
}
