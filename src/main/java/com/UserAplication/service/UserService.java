package com.UserAplication.service;

import com.UserAplication.model.UserData;
import com.UserAplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // Method to save user
   public void addUser(UserData userData){
       this.userRepository.save(userData);
   }

   // Method to get all the users
    public List<UserData> getAllUsers(){
         return (List<UserData>) this.userRepository.findAll();
    }

    // Method to delete a user
    public void deleteUser(Integer id){
       this.userRepository.deleteById(id);
    }

    //Method to get user by id
    public Optional<UserData> getUserByID(Integer id){
       return this.userRepository.findById(id);
    }

   // Method to get user by name
    public List<UserData> findByUserName(String name){
        return this.userRepository.findAllByName(name);
    }


}
