package com.example.EmployeeApp.service;

import com.example.EmployeeApp.model.Users;
import com.example.EmployeeApp.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UsersRepo usersRepo;

    private BCryptPasswordEncoder bencoder = new BCryptPasswordEncoder(12);


    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public Users register(Users users) {
        users.setPassword(bencoder.encode(users.getPassword()));
        return usersRepo.save(users);
    }

    public List<Users> getUsers() {
        return usersRepo.findAll();
    }
}
