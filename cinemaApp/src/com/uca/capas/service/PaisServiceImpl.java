package com.uca.capas.service;

import com.uca.capas.domain.Pais;
import com.uca.capas.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("paisService")
@Transactional
public class PaisServiceImpl implements PaisService{
	@Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }
}
