package pl.dofizjo.dofizjoapplication.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dofizjo.dofizjoapplication.data.UserRepository;
import pl.dofizjo.dofizjoapplication.model.User;

@Service
public class DofizjoUserDetailsService implements UserDetailsService {

    private UserRepository userRepo;

    public DofizjoUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User" + username + "not found");
    }

}
