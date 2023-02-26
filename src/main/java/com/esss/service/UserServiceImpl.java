package com.esss.service;

import com.esss.converter.UserConverter;
import com.esss.dao.UserDAO;
import com.esss.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO data;
    private final UserConverter userConverter;


    public UserServiceImpl(UserDAO data, UserConverter userConverter) {
        this.data = data;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getUserById(String id) {
        return userConverter.entityToDto(data.getUserById(id));
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean editUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean removeUser(String id) {
        return false;
    }

    @Override
    public List<UserDTO> getUsersByRole(String role){
        return userConverter.entityToDto(data.getUsersByRole(role));
    }

    @Override
    public List<UserDTO> addNewUserToListOfExistingUsers(List<String> userEmailList) {
        return userConverter.entityToDto(data.addNewUserToListOfExistingUsers(userEmailList));
    }

    @Override // this is for updating --- it will take the new list of UserID to be add and an existing list of users, it will crosscheck the two and return a String list of checked_userID
    public List<String> checkIfUsersExistInListOfUsers(List<String> userEmailList, List<UserDTO> userList) {
        return data.checkIfUsersExistInListOfUsers(userEmailList, userConverter.dtoToEntity(userList));
    }
//    @Override
//    public List<UserDTO> getStaff(){
//        return  userConverter.entityToDto(data.getStaff());
//    }
}
