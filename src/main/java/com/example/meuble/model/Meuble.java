package com.example.meuble.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.example.meuble.connection.Connect;

public class Meuble {
    int id_meuble;
    int id_categorie;
    int id_style;
    int id_volume;
    double prix;

    public Meuble(int id_meuble, int id_categorie, int id_style, int id_volume, double prix) {
        this.id_meuble = id_meuble;
        this.id_categorie = id_categorie;
        this.id_style = id_style;
        this.id_volume = id_volume;
        this.prix = prix;
    }
    public Meuble() {
    }
    public int getId_meuble() {
        return id_meuble;
    }
    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }
    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public int getId_style() {
        return id_style;
    }
    public void setId_style(int id_style) {
        this.id_style = id_style;
    }
    public int getId_volume() {
        return id_volume;
    }
    public void setId_volume(int id_volume) {
        this.id_volume = id_volume;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

     public void insertMeuble(Connection c, int id_categorie, int id_style, int id_volume, double prix)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            List<Style> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "insert into meuble(id_categorie,id_style,id_volume,prix) values("+id_categorie+","+id_style+","+id_volume+","+prix+")";
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
