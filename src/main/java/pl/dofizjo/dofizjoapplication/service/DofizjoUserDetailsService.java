package pl.dofizjo.dofizjoapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dofizjo.dofizjoapplication.data.UserRepository;
import pl.dofizjo.dofizjoapplication.model.User;

import javax.servlet.http.HttpServletRequest;

@Service
public class DofizjoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String ip = getIP();
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("IP blocked, max attempts exceeded");
        }

        User user = userRepo.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User" + username + "not found");
    }

    private String getIP() {
        String header = request.getHeader("X-Forwarded-For");
        if (header == null) {
            return request.getRemoteAddr();
        } else {
            return header.split(",")[0];
        }
    }

}
