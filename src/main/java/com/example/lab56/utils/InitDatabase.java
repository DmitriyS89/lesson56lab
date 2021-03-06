package com.example.lab56.utils;

import com.example.lab56.domain.User;
import com.example.lab56.repository.TaskRepository;
import com.example.lab56.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

//package com.example.lab56.utils;
//
//import com.example.lab56.domain.User;
//import com.example.lab56.repository.TaskRepository;
//import com.example.lab56.repository.UserRepository;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import kz.attractorschool.moviereviewrr.model.Movie;
//import kz.attractorschool.moviereviewrr.model.Review;
//import kz.attractorschool.moviereviewrr.model.User;
//import kz.attractorschool.moviereviewrr.repository.MovieRepository;
//import kz.attractorschool.moviereviewrr.repository.ReviewRepository;
//import kz.attractorschool.moviereviewrr.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Stream;
//
//import static java.util.stream.Collectors.*;
//
@Configuration
public class InitDatabase {

    private static final Random r = new Random();

    @Bean
    CommandLineRunner init(UserRepository userRepository, TaskRepository taskRepository) {
        return (args) -> {
            userRepository.deleteAll();
            taskRepository.deleteAll();


            userRepository.save(User.builder()
                    .email("test@gmail.com")
                    .password(new BCryptPasswordEncoder().encode("123"))
                    .name("test")
                    .nickName("test")
                    .build());
        };
    }
}

////            var demoUser = User.random();
////            demoUser.setEmail("demo@demo");
////            userRepo.save(demoUser);
////
////            List<User> movies = readUsers("users.json");
////
////            List<User> users = Stream.generate(User::random)
////                    .limit(10)
////                    .collect(toList());
////            userRepo.saveAll(users);
////
////            List<Review> reviews = new ArrayList<>();
////
////            users.forEach(user -> {
////                selectRandomMovies(movies, r.nextInt(3)+1).stream()
////                        .map(movie -> Review.random(user, movie))
////                        .peek(reviews::add)
////                        .forEach(reviewRepository::save);
////            });
////
////            reviews.stream()
////                    .collect(groupingBy(Review::getMovie, averagingDouble(Review::getStars)))
////            .forEach(Movie::setRating);
////
////            movieRepo.saveAll(movies);
////
////            var ac = movieRepo.findByActors("BLOOM");
////            System.out.println("done");
////        };
////    }
////
////    private List<Movie> selectRandomMovies(List<Movie> movies, int amountOfMovies) {
////        return Stream.generate(() -> pickRandom(movies))
////                .distinct()
////                .limit(amountOfMovies)
////                .collect(toList());
////    }
////
////    private static Movie pickRandom(List<Movie> movies) {
////        return movies.get(r.nextInt(movies.size()));
////    }
////
////    private static List<Movie> readMovies(String fileName) {
////        try {
////            ObjectMapper mapper = new ObjectMapper();
////            var data = Files.readString(Paths.get(fileName));
////            var listType = new TypeReference<List<Movie>>(){};
////            return mapper.readValue(data, listType);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return List.of();
////    }
//}
