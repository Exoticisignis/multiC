package com.example.multicinema.repositories;

import com.example.multicinema.entities.Uzytkownik;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRep extends CrudRepository<Uzytkownik, Integer> {
}
