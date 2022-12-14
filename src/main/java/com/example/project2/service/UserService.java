package com.example.project2.service;

import com.example.project2.dto.UserDTO;
import com.example.project2.entity.User;
import com.example.project2.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;

    }
    public List<UserDTO>getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }
    //Filter users by ID
    //select * from user where id=2
    public UserDTO getUserByUserID(String userID){
        User user=userRepo.getUserByUserID(userID);
        return modelMapper.map(user,UserDTO.class);
    }


    //Filter users by ID,Address
    //select * from user  where id= and address="Kandy"

    public UserDTO getUserByUserIDAndAddress(String userID,String address){
        User user=userRepo.getUserByUserIDAndAddress(userID,address);
        return modelMapper.map(user,UserDTO.class);
    }
}
