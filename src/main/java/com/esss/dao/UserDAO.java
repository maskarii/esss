package com.esss.dao;

import com.esss.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(String id);
    boolean createUser(User user);
    User getUserByEmail(String email);
    boolean updateUser(User user);
    boolean deleteUser(String id);
    List<User> addNewUserToListOfExistingUsers(List<String> userEmailList);
    List<String> checkIfUsersExistInListOfUsers(List<String> userEmailList, List<User> userList);
//    void addRoleToUser

    // for testing
    List<User> getUsersByRole(String role);
//    List<User> getStaff();
}
