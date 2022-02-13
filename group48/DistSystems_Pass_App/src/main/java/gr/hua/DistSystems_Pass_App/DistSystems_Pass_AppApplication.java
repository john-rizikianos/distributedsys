package gr.hua.DistSystems_Pass_App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DistSystems_Pass_AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistSystems_Pass_AppApplication.class, args);
	}

}
