package com.csi;

import com.csi.model.User;
import com.csi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringbootjwtdemoApplication {

    @Autowired
    UserServiceImpl userServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootjwtdemoApplication.class, args);
    }

    @PostConstruct
    public User saveUserInformation() {
      return  userServiceImpl.saveData(new User(121, "swara@email.com", "swara@123"));

    }


}
