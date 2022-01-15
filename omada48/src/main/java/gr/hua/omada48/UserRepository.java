package gr.hua.working_app;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gr.hua.working_app.Pog;

@Repository public interface UserRepository extends JpaRepository<Pog, String> {
    Optional<Pog> findUserByUsername(String full_name);
}
