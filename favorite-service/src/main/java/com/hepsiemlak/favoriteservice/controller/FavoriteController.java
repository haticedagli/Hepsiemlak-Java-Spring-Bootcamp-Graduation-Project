package com.hepsiemlak.favoriteservice.controller;

import com.hepsiemlak.favoriteservice.model.Favorite;
import com.hepsiemlak.favoriteservice.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFavorite(@RequestBody Favorite favoriteRequest) {
        favoriteService.save(favoriteRequest);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Favorite>> getUserFavorites(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(favoriteService.getUserFavorites(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable("id") String id) {
        return new ResponseEntity<>(favoriteService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFavoriteById(@PathVariable("id") String id) {
        favoriteService.deleteById(id);
    }

}
