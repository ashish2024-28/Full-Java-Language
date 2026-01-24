package com.digitaleducationrecord.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitaleducationrecord.app.Entity.User;
import com.digitaleducationrecord.app.Service.UserService;

@RestController
@RequestMapping("/home")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String test() {
        return "home Access OK";
    }

     // User Login by Email + Password
    @GetMapping("/user_login")
    public ResponseEntity<?> userLogin(@RequestParam String email , @RequestParam String password){
        try {

            User loginUser = userService.loginUser(email, password);
            return new ResponseEntity<>(loginUser,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create_user")
    // public ResponseEntity<?> add(@PathVariable String domain, @RequestBody Student s) {
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            String saveUser = userService.createUser(user);
            return new ResponseEntity<>(saveUser,HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
