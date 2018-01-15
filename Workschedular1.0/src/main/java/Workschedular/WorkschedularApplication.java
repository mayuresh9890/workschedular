package Workschedular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"Workschedular","controller"})
public class WorkschedularApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkschedularApplication.class, args);
	}
}
