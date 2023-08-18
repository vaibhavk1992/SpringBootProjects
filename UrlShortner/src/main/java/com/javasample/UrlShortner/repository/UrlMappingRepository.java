package com.javasample.UrlShortner.repository;

import com.javasample.UrlShortner.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UrlMappingRepository extends JpaRepository<UrlMapping,Integer> {
    @Override
    List<UrlMapping> findAll();
}
