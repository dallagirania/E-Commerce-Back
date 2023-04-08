package com.example.E_ADMIN.RestController;

import com.example.E_ADMIN.Entite.User;
import com.example.E_ADMIN.Repository.AdminRepository;
import com.example.E_ADMIN.Repository.UserRepository;
import com.example.E_ADMIN.Service.AdminService;
import com.example.E_ADMIN.Service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user")
public class UserRestController {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public UserRestController(UserRepository candidatRepository) {this.userRepository= userRepository;}

    @PostMapping(path = "loginuser")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody User user) {

        HashMap<String, Object> response = new HashMap<>();

        User userFromDB = userRepository.findIdByEmail(user.getEmail());

        if (userFromDB == null) {
            response.put("message", "User not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }  else {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
    @PostMapping(path = "registeruser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        if(userRepository.existsByEmail(user.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        user.setMdp(this.bCryptPasswordEncoder.encode(user.getMdp()));
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User ajouterUser(@RequestBody User user){
        return userService.ajouterUser(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User modifierUser(@PathVariable("id")Long id,@RequestBody User user){
        User newUser=userService.modifierUser(user);
        return newUser;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<User> GetUserById(@PathVariable("id")Long id){
        Optional<User>user=userService.GetUserById(id);
        return user;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerUser(@PathVariable("id")Long id){
        userService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.listUser();
    }


}

