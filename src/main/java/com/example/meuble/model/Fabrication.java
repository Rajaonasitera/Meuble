package com.example.meuble.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.meuble.connection.Connect;

public class Fabrication {
    int id_fabrication;
    int id_style_materiel;
    int id_categorie;
    int id_volume;
    double quantite;

    public Fabrication(int id_fabrication, int id_style_materiel, int id_categorie, int id_volume, double quantite) {
        this.id_fabrication = id_fabrication;
        this.id_style_materiel = id_style_materiel;
        this.id_categorie = id_categorie;
        this.id_volume = id_volume;
        this.quantite = quantite;
    }
    public Fabrication() {
    }
    public int getId_fabrication() {
        return id_fabrication;
    }
    public void setId_fabrication(int id_fabrication) {
        this.id_fabrication = id_fabrication;
    }
    public int getId_style_materiel() {
        return id_style_materiel;
    }
    public void setId_style_materiel(int id_style_materiel) {
        this.id_style_materiel = id_style_materiel;
    }
    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public int getId_volume() {
        return id_volume;
    }
    public void setId_volume(int id_volume) {
        this.id_volume = id_volume;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public void insertionQuantite(Connection c, int id_style_materiel, int id_categorie, int id_volume, double quantite)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            List<Style> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "insert into fabrication(id_style_materiel, id_categorie, id_volume, quantite) values("+id_style_materiel+","+id_categorie+","+id_volume+","+quantite+")";
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

    public Fabrication[] getAllFabrication(Connection c)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            List<Style> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from fabrication";
            ResultSet res = st.executeQuery(sql);
            List<Fabrication> allF = new ArrayList<>();
            while (res.next()) {
                allF.add(new Fabrication(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getDouble(5)));
            }
            Fabrication[] all = new Fabrication[allF.size()];
            return allF.toArray(all);
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
