package pl.dofizjo.dofizjoapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.dofizjo.dofizjoapplication.data.*;
import pl.dofizjo.dofizjoapplication.model.*;

@SpringBootApplication
@Slf4j
public class DofizjoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DofizjoApplication.class, args);
	}

	@Autowired
	PasswordEncoder encoder;

	@Bean
	@Profile("dev")
	CommandLineRunner dataLoader(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo, BlockRepository blockRepo, MethodRepository methodRepo, UserRepository userRepo, CommentRepository commentRepo) {
		return args -> {
			userRepo.add(new User("user", encoder.encode("password"), true));
		};
	}
}
