package app_1.jwtApp.controllers;

import app_1.jwtApp.entities.User1;
import app_1.jwtApp.payload.LoginDto;
import app_1.jwtApp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //used for response communicate
@RequestMapping("api/user")   //localhost:8080/api/user
public class UserController { //User Controller

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> createUser(
            @RequestBody User1 user){
        ResponseEntity users = userService.createUser(user);
        return users;
    } //it'll return users object

    @GetMapping("/getMessage")
    public String getMessage(){
        return "Hello";
    }


}
