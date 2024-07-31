package com.mateuspacheco.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mateuspacheco.workshopmongo.domain.Post;
import com.mateuspacheco.workshopmongo.domain.User;
import com.mateuspacheco.workshopmongo.dto.AuthorDTO;
import com.mateuspacheco.workshopmongo.repository.PostRepository;
import com.mateuspacheco.workshopmongo.repository.UserRepository;

/**
 * Instantiation
 */
@Configuration
public class Instantiation implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

    userRepository.deleteAll();
    postRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    userRepository.saveAll(Arrays.asList(maria, alex, bob));

    Post post1 = new Post(null, sdf.parse("22/03/2018"), "Partiu viagem", "Vou viajar para Sao Paulo.",
        new AuthorDTO(maria));
    Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

    postRepository.saveAll(Arrays.asList(post1, post2));

    maria.addPost(post1);
    maria.addPost(post2);

    userRepository.save(maria);
  }
}
