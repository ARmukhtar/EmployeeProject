//package com.example.EmployeeApp.controller;
//
//
//import com.example.EmployeeApp.model.Users;
//import com.example.EmployeeApp.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class UsersController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("register")
//    public Users register(@RequestBody Users users){
//        return userService.register(users);
//    }
//
//    @GetMapping("getusers")
//    public List<Users> getUsers(){
//        return userService.getUsers();
//    }
//}
