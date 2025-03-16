package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getAllUser();
    }
    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);

    }

    @PutMapping("/updateuser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/userdelete")
    public String deleteUser(@RequestBody UserDto userDto) {
        return userService.deleteUser(userDto);
    }

    // Native Query
    @GetMapping("/getuserbyid/{userId}")
    public UserDto getUserByUserId(@PathVariable String userId) {
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/getuserbyidandname/{id}/{name}")
    public UserDto getUserByUserIdAndName(@PathVariable String id,@PathVariable String name) {
        return userService.getUserByUserIdAndName(id,name);
    }
}
