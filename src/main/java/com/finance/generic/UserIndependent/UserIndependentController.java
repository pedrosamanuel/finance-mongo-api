package com.finance.generic.UserIndependent;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class UserIndependentController<T, RES, REQ ,
        S extends UserIndependentService<T,RES, REQ,R,ID>,
        R extends UserIndependentRepository<T,ID>, ID>{

    private final S service;
    public UserIndependentController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RES>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RES> getById(@PathVariable ID id) {
        Optional<RES> entity = service.findByIdDTO(id);
        return entity.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody REQ request) {
        service.save(request);
        return ResponseEntity.ok("Entidad Creada");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable ID id, @RequestBody REQ request) {
        Boolean isUpdated = service.update(id,request);
        if (isUpdated) {
            return ResponseEntity.ok("Entidad Actualizada");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable ID id) {
        Boolean isDeleted = service.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Entidad Eliminada");
        }
        return ResponseEntity.notFound().build();
    }
}
