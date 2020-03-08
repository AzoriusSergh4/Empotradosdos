package practica1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Practica1SdApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Practica1SdApplication.class, args);
	}

}
