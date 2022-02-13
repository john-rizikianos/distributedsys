package gr.hua.DistSystems_Pass_App;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    Application findByUserName(String userName);
}
