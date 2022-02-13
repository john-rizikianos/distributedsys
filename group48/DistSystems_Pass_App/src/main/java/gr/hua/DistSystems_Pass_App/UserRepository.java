package gr.hua.DistSystems_Pass_App;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByFullName(String fullName);
}
