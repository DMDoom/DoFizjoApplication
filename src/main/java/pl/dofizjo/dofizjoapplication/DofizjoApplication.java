package pl.dofizjo.dofizjoapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.dofizjo.dofizjoapplication.data.*;
import pl.dofizjo.dofizjoapplication.model.*;

@SpringBootApplication
@Slf4j
@ConfigurationProperties(prefix="dofizjo.security")
public class DofizjoApplication {

	String username;
	String password;

	public static void main(String[] args) {
		SpringApplication.run(DofizjoApplication.class, args);
	}

	@Autowired
	PasswordEncoder encoder;

	@Bean
	@Profile("dev")
	CommandLineRunner dataLoaderDev(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo, BlockRepository blockRepo, MethodRepository methodRepo, UserRepository userRepo, CommentRepository commentRepo) {
		return args -> {
			userRepo.add(new User("user", encoder.encode("password"), true));
		};
	}

	@Bean
	@Profile("prod")
	CommandLineRunner dataLoaderProd(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo, BlockRepository blockRepo, MethodRepository methodRepo, UserRepository userRepo, CommentRepository commentRepo) {
		return args -> {
			userRepo.add(new User(username, encoder.encode(password), true));
		};
	}
}
