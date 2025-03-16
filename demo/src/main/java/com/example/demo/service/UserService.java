package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getAllUser(){
    List<User> userList = userRepo.findAll();
    return modelMapper.map(userList,new TypeToken<List<UserDto>>(){}.getType());
    }

    public UserDto saveUser(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        user = userRepo.save(user);
        return modelMapper.map(user,UserDto.class);

        //Easy Method
//        userRepo.save(modelMapper.map(userDto,User.class));
//        return userDto;

    }

    public UserDto updateUser(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        user = userRepo.save(user);
        return  modelMapper.map(user,UserDto.class);
    }

    public String deleteUser(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        userRepo.delete(user);
        return "User Deleted Successfully";
    }

    // Native Query

    public UserDto getUserByUserId(String userId){
        User user = userRepo.getUserByUserId(userId);
        return modelMapper.map(user,UserDto.class);
    }

    public UserDto getUserByUserIdAndName(String id,String name){
        User user = userRepo.getUserByUserIdAndName(id,name);
        return modelMapper.map(user,UserDto.class);
    }

}
