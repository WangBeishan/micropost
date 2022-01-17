package ml.sunmonkey.micropost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MicropostApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicropostApplication.class, args);
	}

}
