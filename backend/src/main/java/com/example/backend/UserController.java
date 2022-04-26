package com.example.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")

@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    
    @Autowired
    private UserRepository  UserRepository ;

    @GetMapping("/")
    public List<User> getuser(){
        return UserRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserbyid(@PathVariable Integer id){
        return UserRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public User adduser(@RequestBody User user){
        return UserRepository.save(user);
    } 

    @PutMapping("/update")
    public User updateUser(@RequestBody User User){
        User oldUser = UserRepository.findById(User.getId()).orElse(null);
        oldUser.setStudentName(User.getStudentName());
        oldUser.setYear(User.getYear());
        oldUser.setBranch(User.getBranch());
        oldUser.setSection(User.getBranch());
        oldUser.setStudentRollNo(User.getStudentRollNo());
        return UserRepository.save( oldUser);
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable Integer id){
        UserRepository.deleteById(id);
    }

    @GetMapping("/check/{name}/{password}")
    public int CheckUser(@PathVariable String name,@PathVariable String password){
        int x;
        try{
            x= UserRepository.findUser(name, password);
        }
        catch(Exception e){
            System.out.println("wrong crediantls");
            return 0;
        }
        return x;
    }
    
    

    
}
