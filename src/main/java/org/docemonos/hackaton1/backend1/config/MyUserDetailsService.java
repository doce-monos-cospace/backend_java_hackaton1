package org.docemonos.hackaton1.backend1.config;

import lombok.RequiredArgsConstructor;
import org.docemonos.hackaton1.backend1.dao.UserRepository;
import org.docemonos.hackaton1.backend1.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByNameEquals(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new MyUserDetails(user);
    }
}
