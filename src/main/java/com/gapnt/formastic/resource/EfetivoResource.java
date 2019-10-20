package com.gapnt.formastic.resource;

import com.gapnt.formastic.model.Efetivo;
import com.gapnt.formastic.service.EfetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/efetivos-astic")
public class EfetivoResource {

    @Autowired
    private EfetivoService service;

    @GetMapping
    public List<Efetivo> findAll(){
        return service.listaTodos();
    }

    @GetMapping("/id")
    public ResponseEntity<Efetivo> findById(@PathVariable("id") Long id){
        try {
            Efetivo efetivo = service.listaPorId(id);
            return ResponseEntity.ok(efetivo);
        } catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Efetivo> cria(@RequestBody Efetivo efetivo, HttpServletResponse response){
        Efetivo e = service.salva(efetivo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(e.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(e);
    }

}
