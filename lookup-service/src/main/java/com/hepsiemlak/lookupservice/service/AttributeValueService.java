package com.hepsiemlak.lookupservice.service;

import com.hepsiemlak.lookupservice.exception.BadRequestException;
import com.hepsiemlak.lookupservice.exception.NotFoundException;
import com.hepsiemlak.lookupservice.model.AttributeValue;
import com.hepsiemlak.lookupservice.repository.AttributeValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttributeValueService {

    private final AttributeValueRepository attributeValueRepository;

    public void create(AttributeValue attributeValueRequest) {
        if(attributeValueRequest.getId() != null) throw new BadRequestException("Attribute value id must be null");
        attributeValueRepository.save(attributeValueRequest);
    }

    public AttributeValue findById(String id) {
        return attributeValueRepository.findById(id).orElseThrow(() -> new NotFoundException("Attribute value not found"));
    }

    public void deleteById(String id) {
        attributeValueRepository.deleteById(id);
    }

    public AttributeValue update(AttributeValue attributeValueRequest) {
        if (!attributeValueRepository.existsById(attributeValueRequest.getId())) {
            throw new NotFoundException("Attribute value not found");
        }
        return attributeValueRepository.save(attributeValueRequest);
    }
}
