package com.example.multicinema.services;

import com.example.multicinema.entities.Uzytkownik;

public interface UserService {
    public Iterable<Uzytkownik> getAll();
    public Uzytkownik get(int id);
    public Uzytkownik addUser(Uzytkownik user);
    public void deleteUser(int id);
    public void updateUser(int id, Uzytkownik user);
    public boolean login(String haslo, String login);
}
