package com.gapnt.formastic.controller;

import com.gapnt.formastic.model.Efetivo;
import com.gapnt.formastic.service.EfetivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/efetivos")
public class EfetivoController {

    @Autowired
    private EfetivoService service;

    @GetMapping
    public String listaTodos(Model model){
        Efetivo efetivo = new Efetivo();
        model.addAttribute("efetivo", efetivo);
        List<Efetivo> efetivos = service.listaTodos();
        model.addAttribute("efetivos", efetivos);
        return "efetivos";
    }

    @PostMapping
    public String salva(Efetivo efetivo){
        service.salva(efetivo);
        return "redirect:/efetivos";
    }

    @GetMapping("/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
        service.removePorId(id);
        return "redirect:/efetivos";
    }

    @GetMapping("/{id}/edita")
    public String edita(@PathVariable("id") Long id, Model model){
        Efetivo efetivo = service.listaPorId(id);
        model.addAttribute("efetivo", efetivo);
        List<Efetivo> efetivos = service.listaTodos();
        model.addAttribute("efetivos", efetivos);
        return "efetivos";
    }

}
