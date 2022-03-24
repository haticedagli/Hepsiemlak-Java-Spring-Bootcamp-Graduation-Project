package com.hepsiemlak.lookupservice.controller;

import com.hepsiemlak.lookupservice.model.Attribute;
import com.hepsiemlak.lookupservice.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/attribute")
public class AttributeController {

    private final AttributeService attributeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Attribute request) {
        attributeService.create(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Attribute> update(@RequestBody Attribute request) {
        return new ResponseEntity<>(attributeService.update(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Attribute> getAttributeById(@PathVariable("id") String id) {
        return new ResponseEntity<>(attributeService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFAttributeById(@PathVariable("id") String id) {
        attributeService.deleteById(id);
    }
}
