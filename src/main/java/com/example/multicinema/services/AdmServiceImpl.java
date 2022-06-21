package com.example.multicinema.services;

import com.example.multicinema.entities.Administrator;
import com.example.multicinema.repositories.AdmRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class AdmServiceImpl implements AdmService{
    @Autowired
    private AdmRep admRep;
    @Override
    public Iterable<Administrator> getAll(){
        return admRep.findAll();
    }

    @Override
    public Administrator get(int id) {
        return admRep.findById(id).get();
    }

    @Override
    public Administrator addAdm(Administrator adm) {
        return admRep.save(adm);
    }

    @Override
    public void deleteAdm(int id) {
        admRep.deleteById(id);
    }

    @Override
    public void updateAdm(int id, Administrator ad) {
        admRep.deleteById(id);
        ad.setIdA(id);
        admRep.save(ad);
    }
    @Override
    public boolean login(String haslo, String login){
        String url = "jdbc:sqlite:cinemadb.db";
        String sql = "SELECT * FROM Administratorze WHERE haslo=\""+haslo+"\" AND login=\""+login+"\"";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println(rs.getInt("idA") + "\t" +
                        rs.getString("email"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
