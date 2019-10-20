package com.gapnt.formastic.service;

import com.gapnt.formastic.model.Efetivo;
import com.gapnt.formastic.repository.EfetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EfetivoService {

    @Autowired
    private EfetivoRepository repository;

    public List<Efetivo> listaTodos() {
        return repository.findAll();
    }

    public Efetivo salva(Efetivo efetivo){
        return repository.save(efetivo);
    }

    public void removePorId(Long id){
        repository.deleteById(id);
    }

    public Efetivo listaPorId(Long id){
        return repository.findById(id).get();
    }
}
