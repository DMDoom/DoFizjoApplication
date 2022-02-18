package pl.dofizjo.dofizjoapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.dofizjo.dofizjoapplication.data.*;
import pl.dofizjo.dofizjoapplication.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DofizjoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DofizjoApplication.class, args);
	}

	@Autowired
	PasswordEncoder encoder;

	// TODO:
	// DataSource with MySQL, MySQL driver dependency maybe

	@Bean
	CommandLineRunner dataLoader(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo, BlockRepository blockRepo, MethodRepository methodRepo, UserRepository userRepo, CommentRepository commentRepo) {
		return args -> {
			userRepo.add(new User("test", encoder.encode("test"), true));

			// Comment test
			Comment comment = new Comment(3, "Developer", "Lorem ipsum", new Date());
			commentRepo.add(comment);

		};
	}
}
