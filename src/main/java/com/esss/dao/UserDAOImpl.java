package com.esss.dao;

import com.esss.model.User;
import com.esss.repository.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private final UserRepo repo;
    public UserDAOImpl(UserRepo repo) {this.repo = repo;}

    @Override
    public List<User> getAllUsers() {return repo.findAll();}

    @Override
    public User getUserById(String id) {return repo.findById(id).get();}

    @Override
    public boolean createUser(User user) {
        if (user != null) {
            repo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return repo.getUserByEmail(email);
    }

    @Override
    public boolean updateUser(User user) {
        if (this.getUserById(user.getId()) != null) {
            repo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        if (this.getUserById(id) != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public List<User> addNewUserToListOfExistingUsers(List<String> userEmailList) {
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i < userEmailList.size(); i++){
            userList.add(this.getUserByEmail(userEmailList.get(i)));
        }
        return userList;
    }

    @Override
    public List<String> checkIfUsersExistInListOfUsers(List<String> userEmailList, List<User> userList) { // cross-check between userIDs list(String)  and userID of each user in list of object users
        List<String> comparinglist = new ArrayList<String>();
        if(userList != null){
            for(User user: userList){
                comparinglist.add(user.getEmail());
            }
            userEmailList.removeAll(comparinglist);
            return userEmailList;
        }else {
            return userEmailList;
        }
    }

    //Test purpose
    @Override
    public List<User> getUsersByRole(String role){
        return repo.getUsersByRole(role);
    }

//    @Override
//    public List<User> getStaff(){
//        return repo.getAllStaff();
//    }
}
