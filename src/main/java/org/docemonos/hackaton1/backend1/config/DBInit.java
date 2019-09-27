package org.docemonos.hackaton1.backend1.config;

import lombok.RequiredArgsConstructor;
import org.docemonos.hackaton1.backend1.dao.UserRepository;
import org.docemonos.hackaton1.backend1.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class DBInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User manolo = new User("manolo", passwordEncoder.encode("pass1234"),"ADMIN");
        User estefania = new User("estefania", passwordEncoder.encode("pass1234"),"USER");
        User diana = new User("dianam", passwordEncoder.encode("pass1234"),"USER");


        userRepository.saveAll(Arrays.asList(manolo,estefania, diana));

    }
}
