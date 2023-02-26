package com.esss.dao;

import com.esss.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getAllRoles();
    Role getRoleById(String id);
//    Role getRoleByName(String name);
    boolean createRole(Role role);
    boolean updateRole(Role role);
    boolean deleteRole(String id);
}
