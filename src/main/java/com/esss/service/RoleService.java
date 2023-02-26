package com.esss.service;

import com.esss.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRoles();
    RoleDTO getRoleById(String id);
    boolean addRole(RoleDTO roleDTO);
    boolean editRole(RoleDTO roleDTO);
    boolean removeRole(String id);
}
