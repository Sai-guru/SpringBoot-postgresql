package com.example.springbootPostgresql.controllers;
import com.example.springbootPostgresql.entity.UserEntity;
import com.example.springbootPostgresql.exception.ResourceNotFoundException;
import com.example.springbootPostgresql.repository.UserRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
// import java.util.Optional;

// import java.util.Arrays;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
    // Note - below I added some endpoints just to understand...
public class UserController {

        private final UserRepository userRepository;

    // @GetMapping("/getUsers")
    // public String getusers() {
    //     return "hello guru";
    // }
    @GetMapping("/getUsers")
    public List<UserEntity> getUsers() {
        // return Arrays.asList(new User(1L,"john doe","john.doe@example.com"),
        //                      new User(2L,"jane smith","jane.smith@example.com"));
          return userRepository.findAll();
    }
    
    @PostMapping("/createUser")
    public UserEntity createUser(@RequestBody UserEntity user) {
 
       // System.out.println("Created user: "+user.getName());
        return userRepository.save(user);     
    }

    @GetMapping("/getUserById/{id}")
    public UserEntity getUserById(@PathVariable Long id) {

        /// here just giveing Optional.Of will not give a correct error status ..
        /// it musst be 404 not found if id is not present..so craeting 
        /// another making exception for resource Not found exception...
        
        return userRepository.findById(id)
          .orElseThrow(()-> new ResourceNotFoundException("User with id "+id+" is not found"));  
    }    // 2 lines for easy reading
    

    @PutMapping("/updateUser/{id}")
    public UserEntity update(@PathVariable Long id,@RequestBody UserEntity user) {

        UserEntity existingUser = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser); 
    }


    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {

        UserEntity existingUser = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        userRepository.delete(existingUser);
        return "deleted user with id "+id; 
    }
    
    

}
 