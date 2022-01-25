package pl.dofizjo.dofizjoapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.dofizjo.dofizjoapplication.data.*;
import pl.dofizjo.dofizjoapplication.model.*;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DofizjoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DofizjoApplication.class, args);
	}

	@Bean CommandLineRunner dataLoader(PostRepository postRepo, PartnerRepository partnerRepo, ReviewRepository reviewRepo, BlockRepository blockRepo, MethodRepository methodRepo) {
		return args -> {
			// Partners
			partnerRepo.add(new Partner(1, "/images/logos/areadance.png", "Area Dance", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			partnerRepo.add(new Partner(2, "/images/logos/hazestudio.png", "Haze Studio", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			partnerRepo.add(new Partner(3, "/images/logos/huntergym.png", "Hunter Gym", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			partnerRepo.add(new Partner(4, "/images/logos/organicfitness.jpg", "Organic Fitness", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));

			// Reviews
			reviewRepo.add(new Review(1, "Jan Kowalski", "MMA", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			reviewRepo.add(new Review(1, "Jan Kowalski", "Strongman", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			reviewRepo.add(new Review(1, "Jan Kowalski", "Taniec", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));
			reviewRepo.add(new Review(1, "Jan Kowalski", "Lorem", "In ornare imperdiet risus, at aliquet massa rutrum ac. Vestibulum mollis massa lectus, et pulvinar libero porta et."));

			// Blocks
			blockRepo.add(new Block("lokalizacja", "ul. Gdańska 28/4", "+48 731 278 308"));
			blockRepo.add(new Block("zapraszamy", "zapraszamy", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc in lorem in erat bibendum scelerisque in in ipsum. Aliquam at interdum lorem. Donec vel odio vel lectus viverra scelerisque. Donec venenatis faucibus magna id viverra. Cras aliquet dignissim quam, vitae ultricies libero ultrices vitae. Phasellus ut fringilla purus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent libero tortor, posuere sit amet nunc at, semper dictum purus. Etiam at purus eget nibh rutrum egestas."));
			blockRepo.add(new Block("oferta", "oferta", "Aenean et bibendum felis, in vestibulum libero. Suspendisse nibh tortor, lobortis non odio nec, luctus rhoncus diam. Phasellus pretium, nulla nec volutpat tempor, ipsum est scelerisque augue, eget vestibulum neque velit et nunc. Ut suscipit augue ex, ac auctor orci interdum vitae. Morbi posuere lacinia enim sit amet sollicitudin."));
			blockRepo.add(new Block("mateusz", "Mateusz", "In dictum, nibh sed auctor venenatis, orci ante condimentum lorem, in mattis orci nisl ac nisi. Pellentesque in eros odio. Etiam faucibus, metus nec porta dignissim, neque leo consequat dolor."));
			blockRepo.add(new Block("karol", "Karol", "In dictum, nibh sed auctor venenatis, orci ante condimentum lorem, in mattis orci nisl ac nisi. Pellentesque in eros odio. Etiam faucibus, metus nec porta dignissim, neque leo consequat dolor."));
			blockRepo.add(new Block("rafal", "Rafał", "In dictum, nibh sed auctor venenatis, orci ante condimentum lorem, in mattis orci nisl ac nisi. Pellentesque in eros odio. Etiam faucibus, metus nec porta dignissim, neque leo consequat dolor."));
			blockRepo.add(new Block("metody", "analiza i terapia", "Etiam faucibus, metus nec porta dignissim, neque leo consequat dolor, quis fermentum tellus augue id turpis. Fusce pulvinar quis sem sit amet suscipit."));
			blockRepo.add(new Block("kontakt", "kontakt", "dofizjoterapeuty@gmail.com"));

			// Methods
			methodRepo.add(new Method("Terapia skojarzona", "Terapia zawierająca w sobie wszystkie metody potrzebne do zmniejszenia lub całkowitego zniesienia bólu."));
			methodRepo.add(new Method("Terapia powięziowa", "Jest to praca na tkankach miękkich mająca na celu normalizacje napięć, a w efekcie zmniejszenie dolegliwości bólowych w układzie ruchu."));
			methodRepo.add(new Method("Korekcja wad postawy", "Terapia mająca na celu, zmniejszenie lub wyeliminowanie asymetrii w ciele."));
			methodRepo.add(new Method("Kinesiotaping", "plastrowanie dynamiczne powoduje normalizacje napięcia mięśniowego, w zależności od rodzaju aplikacji poprawia ruchomości, zmniejsza dolegliwości bólowe, czy wspomaga drenaż limfatyczny."));
			methodRepo.add(new Method("Masaż klasyczny", "Powtarzalna sekwencja ruchów - praca na powierzchownych tkankach miękkich, w celu poprawy regeneracji. Niezalecany dla pacjentów bólowych."));
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
