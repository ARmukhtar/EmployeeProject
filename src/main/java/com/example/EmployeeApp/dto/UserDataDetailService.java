//package com.example.EmployeeApp.dto;
//
//import com.example.EmployeeApp.model.Users;
//import com.example.EmployeeApp.repository.UsersRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDataDetailService implements UserDetailsService {
//    @Autowired
//    UsersRepo usersRepo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Users user = usersRepo.findByUsername(username);
//
//        if(user==null){
//            throw new UsernameNotFoundException("UserInfo not Found");
//        }
//        return new UserDataDetails(user);
//    }
//}
