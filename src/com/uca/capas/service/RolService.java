package com.uca.capas.service;

import com.uca.capas.domain.Rol;
import javassist.tools.rmi.ObjectNotFoundException;

import java.util.List;

public interface RolService {
	
    public List<Rol> findAll() throws ObjectNotFoundException;
}
