package com.slizokav.MusicToolsRestApi.repositories;

import com.slizokav.MusicToolsRestApi.model.Brand;
import com.slizokav.MusicToolsRestApi.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByBrandName(String brandName);
}
