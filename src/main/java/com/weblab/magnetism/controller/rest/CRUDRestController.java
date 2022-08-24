package com.weblab.magnetism.controller.rest;

import com.weblab.magnetism.service.interf.CRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CRUDRestController<E, K> {

    abstract CRUDService<E, K> getService();


    @PostMapping
    public ResponseEntity<E> create(@RequestBody E object) {
        getService().create(object);
        return ResponseEntity.ok(object);
    }


    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable K id) {

        E object = getService().findById(id);

        if (object == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(object);
    }


    @GetMapping
    public ResponseEntity<List<E>> findAll() {

        List<E> objects = getService().findAll();
        return ResponseEntity.ok(objects);
    }

    @PutMapping
    public ResponseEntity<E> update(@RequestBody E object) {

        E updatedObject = getService().update(object);
        return ResponseEntity.ok(updatedObject);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable K id) {

        E objectForDelete = getService().findById(id);
        getService().delete(objectForDelete);
        return ResponseEntity.noContent().build();
    }
}
