package com.hepsiemlak.favoriteservice.repository;

import com.hepsiemlak.favoriteservice.model.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends MongoRepository<Favorite, String> {
    List<Favorite> findByUserId(Long userId);
}
