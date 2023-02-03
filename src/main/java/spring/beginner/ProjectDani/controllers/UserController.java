package spring.beginner.ProjectDani.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.beginner.ProjectDani.model.User;
import spring.beginner.ProjectDani.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public User user(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @GetMapping("/")
    public List<User> user(){
        return this.userRepository.findAll();
    }

    @GetMapping("/listMoreThan/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id){
        return this.userRepository.findAllMoreThan(id);
    }

}
