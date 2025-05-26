package app_1.jwtApp.services;

import app_1.jwtApp.entities.User1;
import app_1.jwtApp.payload.LoginDto;
import app_1.jwtApp.repository.User1Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class UserService {

    private User1Repository user1Repository;
//    private PasswordEncoder passwordEncoder;
    public UserService(User1Repository user1Repository){//, PasswordEncoder passwordEncoder){
        this.user1Repository = user1Repository;
//        this.passwordEncoder = passwordEncoder;
    }


    public ResponseEntity createUser(User1 user) {
        Optional<User1> opUserName = user1Repository.findByUsername(user.getUsername());
        if(opUserName.isPresent()){
            return new ResponseEntity<>("username exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Optional<User1> opEmail = user1Repository.findByEmailId(user.getEmailId());
        if(opEmail.isPresent()){
            return new ResponseEntity<>("emailId exists", HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        String encode = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encode);

        String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
        user.setPassword(hashpw);
        user1Repository.save(user);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
    }


}
