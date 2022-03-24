package com.hepsiemlak.lookupservice.controller;

import com.hepsiemlak.lookupservice.model.AttributeValue;
import com.hepsiemlak.lookupservice.service.AttributeValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attribute-value")
public class AttributeValueController {

    private final AttributeValueService attributeValueService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AttributeValue request) {
        attributeValueService.create(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AttributeValue> update(@RequestBody AttributeValue request) {
        return new ResponseEntity<>(attributeValueService.update(request), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AttributeValue> getAttributeById(@PathVariable("id") String id) {
        return new ResponseEntity<>(attributeValueService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFAttributeById(@PathVariable("id") String id) {
        attributeValueService.deleteById(id);
    }
}
