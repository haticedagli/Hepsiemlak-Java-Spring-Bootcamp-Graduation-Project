package com.hepsiemlak.advertservice.controller;

import com.hepsiemlak.advertservice.model.Advert;
import com.hepsiemlak.advertservice.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/advert")
public class AdvertController {

    private final AdvertService advertService;

    @PostMapping
    public void save(@RequestBody Advert advert) throws IOException {
        advertService.save(advert);
    }

    @GetMapping
    public List<Advert> findAll() throws Exception {
        return advertService.findAll();
    }

    @GetMapping("/{id}")
    public Advert findById(@PathVariable String id) throws IOException {
        return advertService.findById(id);
    }
}
