package com.example.multicinema.services;

import com.example.multicinema.entities.Uzytkownik;
import com.example.multicinema.repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

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

    @Override
    public void updateUser(int id, Uzytkownik user) {
        userRep.deleteById(id);
        user.setIdU(id);
        userRep.save(user);
    }

    @Override
    public boolean login(String haslo, String login){
        String url = "jdbc:sqlite:cinemadb.db";
        String sql = "SELECT * FROM Uzytkownicy WHERE haslo=\""+haslo+"\" AND login=\""+login+"\"";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
                if (rs.next()) {
                    System.out.println(rs.getInt("idU") + "\t" +
                            rs.getString("email"));
                    return true;
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
