package com.hepsiemlak.favoriteservice.service;

import com.hepsiemlak.favoriteservice.exception.BadRequestException;
import com.hepsiemlak.favoriteservice.exception.NotFoundException;
import com.hepsiemlak.favoriteservice.model.Favorite;
import com.hepsiemlak.favoriteservice.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public void save(Favorite favoriteRequest) {
        if(favoriteRequest.getId() != null) throw new BadRequestException("Favorite id must be null");
        favoriteRepository.save(favoriteRequest);
    }

    public Favorite findById(String id) {
        return favoriteRepository.findById(id).orElseThrow(() -> new NotFoundException("Favorite not found"));
    }

    public void deleteById(String id) {
        favoriteRepository.deleteById(id);
    }

    public List<Favorite> getUserFavorites(Long userId) {
        return favoriteRepository.findByUserId(userId);
    }

}
