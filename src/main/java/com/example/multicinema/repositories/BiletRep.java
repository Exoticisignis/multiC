package com.example.multicinema.repositories;

import com.example.multicinema.entities.Bilet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("biletRepository")
public interface BiletRep extends CrudRepository<Bilet, Integer> {
}
