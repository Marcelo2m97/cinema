package com.uca.capas.service;

import com.uca.capas.domain.Rol;
import javassist.tools.rmi.ObjectNotFoundException;

import java.util.List;

public interface RolService {
    List<Rol> findAll() throws ObjectNotFoundException;
}
