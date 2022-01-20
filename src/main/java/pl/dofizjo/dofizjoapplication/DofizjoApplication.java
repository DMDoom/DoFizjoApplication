package pl.dofizjo.dofizjoapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.dofizjo.dofizjoapplication.data.BlockRepository;
import pl.dofizjo.dofizjoapplication.data.PartnerRepository;
import pl.dofizjo.dofizjoapplication.data.PostRepository;
import pl.dofizjo.dofizjoapplication.data.ReviewRepository;
import pl.dofizjo.dofizjoapplication.model.Partner;
import pl.dofizjo.dofizjoapplication.model.Post;
import pl.dofizjo.dofizjoapplication.model.Review;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DofizjoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DofizjoApplication.class, args);
	}

	@Bean CommandLineRunner dataLoader(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo) {
		return args -> {
			log.info("FETCHING ALL POSTS: ");
			for (Post post : postRepo.findAll()) {
				log.info(post.toString());
			}

			partnerRepo.add(new Partner(1, "resources/null", "LoremIpsum1", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			partnerRepo.add(new Partner(2, "resources/null", "LoremIpsum2", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			partnerRepo.add(new Partner(3, "resources/null", "LoremIpsum3", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			partnerRepo.add(new Partner(4, "resources/null", "LoremIpsum4", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));

			reviewRepo.add(new Review(1, "Jan Kowalski", "MMA", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			reviewRepo.add(new Review(1, "Jan Kowalski", "Strongman", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			reviewRepo.add(new Review(1, "Jan Kowalski", "Taniec", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			reviewRepo.add(new Review(1, "Jan Kowalski", "Lorem", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
		};
	}

	/*
	@Bean
	public CommandLineRunner dataLoader(PostRepository postRepo, BlockRepository blockRepo, PartnerRepository partnerRepo) {
		return args -> {
			postRepo.add(new Post(1, "Mateusz", "Przygotowania do zawodów", "Lorem ipsum", new Date()));
			postRepo.add(new Post(2, "Karol", "Zalety regularnych wizyt", "Lorem ipsum", new Date()));
			postRepo.add(new Post(3, "Karol", "Długotrwała współpraca", "Lorem ipsum", new Date()));
			postRepo.add(new Post(4, "Mateusz", "Przygotowania do zawodów", "Lorem ipsum", new Date()));
			postRepo.add(new Post(5, "Karol", "Zalety regularnych wizyt", "Lorem ipsum", new Date()));
			postRepo.add(new Post(6, "Karol", "Długotrwała współpraca", "Lorem ipsum", new Date()));
			postRepo.add(new Post(7, "Karol", "Zalety regularnych wizyt", "Lorem ipsum", new Date()));
			postRepo.add(new Post(8, "Karol", "Długotrwała współpraca", "Lorem ipsum", new Date()));


			// Fetching one
			log.info("FETCHING PART BY ID 2: " + postRepo.findById(2).toString());

			// Fetching all
			log.info("FETCHING ALL: ");
			for (Post post : postRepo.findAll()) {
				log.info(post.toString());
			}

			// Fetching recent 5
			log.info("FETCHING LAST 3: ");
			for (Post post: postRepo.findRecent(3)) {
				log.info(post.toString());
			}
		};
	}
	*/
}
