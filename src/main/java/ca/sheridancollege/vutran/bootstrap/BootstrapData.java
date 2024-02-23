package ca.sheridancollege.vutran.bootstrap;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import ca.sheridancollege.vutran.beans.Exercise;
import ca.sheridancollege.vutran.beans.Role;
import ca.sheridancollege.vutran.models.AuthenticationRequest;
import ca.sheridancollege.vutran.repo.ExerciseRepo;
import ca.sheridancollege.vutran.repo.UserRepository;
import ca.sheridancollege.vutran.service.AuthenticationService;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private ExerciseRepo er;
	private UserRepository ur;
	private final AuthenticationService authenticationService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		AuthenticationRequest request = AuthenticationRequest.builder()
				.email("simon.hood@sheridancollege.ca")
				.password("$2a$10$pWPXXn0JtcDzD4xRhtHZcOB0eIdY26.yQPa/g5.Bjmq23uYV50r2m")
				.build();
		authenticationService.register(request);
		
		Exercise ex1 = Exercise.builder()
				.title("ex1")
				.duration(10)
				.performDesc("Performance1")
				.calories(1000)
				.equipmentDesc("Equipment1")
				.build();
		er.save(ex1);
		
		Exercise ex2 = Exercise.builder()
				.title("ex2")
				.duration(20)
				.performDesc("Performance2")
				.calories(2000)
				.equipmentDesc("Equipment2")
				.build();
		er.save(ex2);
		
		Exercise ex3 = Exercise.builder()
				.title("ex3")
				.duration(30)
				.performDesc("Performance3")
				.calories(3000)
				.equipmentDesc("Equipment3")
				.build();
		er.save(ex3);

	}

}
