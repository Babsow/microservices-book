package microservices.book.multipliaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"microservices.book.multipliaction.service"})
public class SocialMultipliactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMultipliactionApplication.class, args);
	}

}
