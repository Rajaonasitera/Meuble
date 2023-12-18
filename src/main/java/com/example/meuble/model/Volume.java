package com.example.meuble.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.meuble.connection.Connect;

public class Volume {
    int id_volume;
    String libelle;

    public Volume(int id_volume, String libelle) {
        this.id_volume = id_volume;
        this.libelle = libelle;
    }
    public Volume() {
    }
    public int getId_volume() {
        return id_volume;
    }
    public void setId_volume(int id_volume) {
        this.id_volume = id_volume;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Volume[] getAllVolume(Connection c)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
            coTest = true;
            List<Volume> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from Volume";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS.add(new Volume(res.getInt(1),res.getString(2)));
            }
            Volume[] all = new Volume[allS.size()];
            return allS.toArray(all);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

     public void insertVolume(Connection c, String libelle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            List<Style> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "insert into volume(libelle) values('"+libelle+"')";
            int ok = st.executeUpdate(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }
    
}
