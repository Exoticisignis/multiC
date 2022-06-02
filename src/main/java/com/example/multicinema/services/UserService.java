package com.example.multicinema.services;

import com.example.multicinema.entities.Uzytkownik;
import org.apache.tomcat.jni.User;

public interface UserService {
    public Iterable<Uzytkownik> getAll();
    public Uzytkownik get(int id);
    public Uzytkownik addUser(Uzytkownik user);
    public void deleteUser(int id);
}
