package com.UserAplication.controller;

import com.UserAplication.model.UserData;
import com.UserAplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // Mapping for user details form get request
    @RequestMapping("/")
    public String homepage(Model model){
        model.addAttribute("user",new UserData());
        return "homepage";
    }

    // Mapping for user details form post request to save data in DB
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String saveUser(UserData user){
        userService.addUser(user);
        return "redirect:/display";
    }

    // Mapping for show user data
    @RequestMapping("/display")
    public String displayData(Model model){
        List<UserData> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "displaydata";
    }

    // Mapping for update user
    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, Model model) {
        Optional<UserData> user = userService.getUserByID(id);
        UserData data = user.get();
        model.addAttribute("data", data);
        return "updateuser";
    }

    // Mapping for delete user
    @RequestMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/display";
    }

    // Mapping for find user by name
    @RequestMapping( "/find")
    public String findUser(@Param("keyword") String keyword, Model model){
        List<UserData> u = userService.findByUserName(keyword);
        model.addAttribute("u",u);
        return "displaydata";
    }

}
