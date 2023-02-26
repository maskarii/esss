package com.esss.service;

import com.esss.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id);
    boolean addUser(UserDTO userDTO);
    boolean editUser(UserDTO userDTO);
    boolean removeUser(String id);
    List<UserDTO> getUsersByRole(String role);
    List<UserDTO> addNewUserToListOfExistingUsers(List<String> userEmailList);
    List<String> checkIfUsersExistInListOfUsers(List<String> userEmailList, List<UserDTO> userList);
//    List<UserDTO> getStaff();
}
