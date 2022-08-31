package com.example.spirits.spirits.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spirits.spirits.model.Spirit;

@Repository
public interface SpiritsRepository extends JpaRepository<Spirit, Integer> {
    public Spirit save (Spirit savedSpirit);
    public Optional<Spirit> findById(int spiritId);
    public List<Spirit> findAll();
    public void deleteById(int spiritId);
}
