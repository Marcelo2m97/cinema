package com.uca.capas.service;

import com.uca.capas.domain.Rol;
import com.uca.capas.repositories.RolRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("rolService")
@Transactional
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository rolRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() throws ObjectNotFoundException {
        List<Rol> roles = rolRepository.findAll();
        if(roles.isEmpty()){
            throw new ObjectNotFoundException("Rol list is empty");
        }
        return roles;
    }
}
