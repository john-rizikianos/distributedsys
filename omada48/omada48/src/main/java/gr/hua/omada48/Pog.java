package gr.hua.working_app;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "POGGERS")
public class Pog implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    private String full_name;
    private String user_password;
    private int user_id;
    private String user_role;
    private String age;
    private String phonenum;
    private String email;
    private String address;
    private String start_date;

    public Pog() {
    }
    public Pog(String full_name, String user_password, int user_id,String user_role, String age, String phonenum, String email, String address, String start_date) {
        this.full_name=full_name;
        this.user_password=user_password;
        this.user_id=user_id;
        this.user_role=user_role;
        this.age=age;
        this.phonenum=phonenum;
        this.email=email;
        this.address=address;
        this.start_date=start_date;

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }

    @Override
    public String getPassword() {
        return user_password;
    }
    public void setPassword(String user_password) {
        this.user_password = user_password;
    }
    @Override
    public String getUsername() {
        return full_name;
    }
    public void setUsername(String full_name) {
        this.full_name=full_name;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }



}
