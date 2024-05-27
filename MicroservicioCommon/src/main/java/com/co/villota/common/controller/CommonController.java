package com.co.villota.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.co.villota.common.service.CommonService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommonController <E, S extends CommonService<E>>{
	
	@Autowired
    protected S service;

    @Value("${config.balanceador.test}")
    protected String balanceadorTest;

    @GetMapping("/balanceador-Test")
    public ResponseEntity<?> balanceadorTest(){
        Map<String, Object> response = new HashMap<String, Object>();

        response.put("balanceador", balanceadorTest);
        response.put("entidades", service.findAll());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id){
        Optional<E> entity = service.findById(id);

        if(entity.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody E entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
