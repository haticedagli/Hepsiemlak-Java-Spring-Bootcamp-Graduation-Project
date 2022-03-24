package com.hepsiemlak.lookupservice.service;

import com.hepsiemlak.lookupservice.exception.BadRequestException;
import com.hepsiemlak.lookupservice.exception.NotFoundException;
import com.hepsiemlak.lookupservice.model.Attribute;
import com.hepsiemlak.lookupservice.repository.AttributeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AttributeService {
    private final AttributeRepository attributeRepository;

    public void create(Attribute attributeRequest) {
        if(attributeRequest.getId() != null) throw new BadRequestException("Attribute id must be null");
        attributeRepository.save(attributeRequest);
    }

    public Attribute findById(String id) {
        return attributeRepository.findById(id).orElseThrow(() -> new NotFoundException("Attribute not found"));
    }

    public void deleteById(String id) {
        attributeRepository.deleteById(id);
    }

    public Attribute update(Attribute attributeRequest) {
        if (!attributeRepository.existsById(attributeRequest.getId())) {
            throw new NotFoundException("Attribute not found");
        }
        return attributeRepository.save(attributeRequest);
    }
}
