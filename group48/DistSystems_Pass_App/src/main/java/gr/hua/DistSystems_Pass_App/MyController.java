package gr.hua.DistSystems_Pass_App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MyController {
    @Autowired
    ApplicationRepository appRepo;

    @Autowired
    UserRepository userRepo;


    @PostMapping(path = "/user/saveApplication", consumes = {"application/json"})
    @ResponseBody
    public void saveApplicationData(@RequestBody Application[] app) {

        Application application = appRepo.findByUserName(app[0].getUserName());

        if (application == null) {
            appRepo.save(app[0]);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your have already submitted your application");
        }
    }


        @PutMapping(value = "/oaed/updateCitizen/{user_name}")
        @ResponseBody
        public void updateCitizen (@RequestBody String status, @PathVariable String user_name){
            User tmpUser = userRepo.findByFullName(user_name);
            tmpUser.setAppStatus(status);
            userRepo.save(tmpUser);
            appRepo.delete(appRepo.findByUserName(user_name));
        }



    @PutMapping(value="/oasa/enableUserPass/{user_name}")
    @ResponseBody
    public void enableCitizenPass(@PathVariable String user_name){
       User updateUser =userRepo.findByFullName(user_name);
       updateUser.setPassStatus("active");
       userRepo.save(updateUser);
    }

    @PostMapping(path="/saveUser",consumes = {"application/json"})
    @ResponseBody
    public void saveUserData(@RequestBody User[] user){

        boolean userExists = userRepo.findByFullName(user[0].getFullName())==null;

        if(userExists){
            userRepo.save(user[0]);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have already registered");
        }
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal MyUserDetails user , Model model) {

        User tmpUser = userRepo.findByFullName(user.getUsername());
        model.addAttribute("user",tmpUser);
        return "user_page";
    }

    @RequestMapping("/admin")
    public String admin(){
        return"admin_page";
    }

    @RequestMapping("/oaed")
    public String oaed(Model model) {
        List<Application> allApplications = appRepo.findAll();
        model.addAttribute("applications",allApplications);
        return "oaed_page";
    }

    @RequestMapping("/oasa")
    public String oasa(Model model) {
        List<User> allUsers = userRepo.findAll();

        List<User> acceptedUserList = allUsers.stream()
                .filter(c -> c.getAppStatus().equals("accepted"))
                .collect(Collectors.toList());

        model.addAttribute("approved_users",acceptedUserList);
        return "oasa_page";
    }

    }