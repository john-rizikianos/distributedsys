package gr.hua.working_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String full_name) throws UsernameNotFoundException {
        Pog user = userRepository.findUserByUsername(full_name)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
        return user;
    }
    public void createUser(UserDetails user) {
        userRepository.save((Pog) user);
    }
}