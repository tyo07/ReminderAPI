package sactio.reminderapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ActivityApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityApiApplication.class, args);
	}

}
