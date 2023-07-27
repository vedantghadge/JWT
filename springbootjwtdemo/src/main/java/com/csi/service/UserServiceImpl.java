package com.csi.service;


import com.csi.model.User;
import com.csi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepoImpl;

    public User saveData(User user){

         return userRepoImpl.save(user);
    }


    public Optional<User> getDataById(int userId){

        return userRepoImpl.findById(userId);
    }

    public List<User> getAllData(){

        return  userRepoImpl.findAll();
    }

    public User updataData(User user){

        return userRepoImpl.save(user);
    }

    public void deleteDataById(int userId){

     userRepoImpl.deleteById(userId);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepoImpl.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), new ArrayList<>());
    }

}
