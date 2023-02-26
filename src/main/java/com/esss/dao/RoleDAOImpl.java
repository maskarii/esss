package com.esss.dao;

import com.esss.model.Role;
import com.esss.repository.RoleRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO{
    private final RoleRepo repo;
    public RoleDAOImpl(RoleRepo repo){this.repo = repo;}

    @Override
    public List<Role> getAllRoles(){return repo.findAll();}

    @Override
    public Role getRoleById(String id){return repo.findById(id).get();}

//    @Override
//    public Role getRoleByName(String name){return repo.}

    @Override
    public boolean createRole(Role role){
        if (role != null) {
            repo.save(role);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRole(Role role){
        if (this.getRoleById(role.getId()) != null) {
            repo.save(role);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRole(String id){
        if (this.getRoleById(id) != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
