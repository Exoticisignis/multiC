package com.example.multicinema.repositories;

import com.example.multicinema.entities.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("filmRepository")
public interface FilmRepository  extends CrudRepository<Film, Integer> {
}
