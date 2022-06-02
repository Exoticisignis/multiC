package com.example.multicinema.repositories;

import com.example.multicinema.entities.Seans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("seansRepository")
public interface SeansRep extends CrudRepository<Seans, Integer> {
}
