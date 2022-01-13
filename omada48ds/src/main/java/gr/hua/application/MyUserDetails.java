package gr.hua.aplication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
  private String userName;	
  public MyUserDetails(String userName) {
	  this.userName = userName;
  }
  public MyUserDetails() {
  }
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities(){
	  return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }
  @Override
  public String getPassword(){
	  return "pass";
  }
  @Override
  public String getUsername(){
	  return userName;
  }
  @Override
  public boolean isAccountNotExpired(){
	  return true;
  }
  public boolean isAccountNotLocked(){
	  return true;
  }
  @Override
  public boolean isCredentialsNotExpired(){
	  return true;
  }
  public boolean isEnabled(){
	  return true;
  }
 
}
