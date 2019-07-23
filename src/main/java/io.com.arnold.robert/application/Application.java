package io.com.arnold.robert.application;

import io.com.arnold.robert.application.entities.User;
import io.com.arnold.robert.application.repositories.UserRepository;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner init(UserRepository userRepository) {
    return args -> {
      Stream.of("Charles", "Denise", "Jennifer", "Helen", "Robert").forEach(name -> {
        User user = new User(name, name.toLowerCase() + "@domain.com");
        userRepository.save(user);
      });
      userRepository.findAll().forEach(System.out::println);
    };
  }
}
