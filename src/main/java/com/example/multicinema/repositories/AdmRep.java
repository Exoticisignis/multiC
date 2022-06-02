package com.example.multicinema.repositories;

import com.example.multicinema.entities.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("admRep")
public interface AdmRep extends CrudRepository<Administrator, Integer> {
}
