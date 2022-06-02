package com.example.multicinema.services;

import com.example.multicinema.entities.Uzytkownik;
import com.example.multicinema.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRep userRep;
    @Override
    public Iterable<Uzytkownik> getAll(){
        return userRep.findAll();
    }

    @Override
    public Uzytkownik get(int id) {
        return userRep.findById(id).get();
    }

    @Override
    public Uzytkownik addUser(Uzytkownik user) {
        return userRep.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRep.deleteById(id);
    }

}
