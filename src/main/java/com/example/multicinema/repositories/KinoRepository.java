package com.example.multicinema.repositories;

import com.example.multicinema.entities.Kino;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("kinoRepository")
public interface KinoRepository extends CrudRepository<Kino, Integer> {
}
