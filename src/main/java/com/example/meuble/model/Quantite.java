package com.example.meuble.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.meuble.connection.Connect;

public class Quantite {
    int id_fabrication;
    int id_style_materiel;
    int id_style;
    int id_categorie;
    int id_volume;
    double quantite;
    public Quantite(int id_fabrication, int id_style_materiel, int id_style, int id_categorie, int id_volume,
            double quantite) {
        this.id_fabrication = id_fabrication;
        this.id_style_materiel = id_style_materiel;
        this.id_style = id_style;
        this.id_categorie = id_categorie;
        this.id_volume = id_volume;
        this.quantite = quantite;
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
    public int getId_style() {
        return id_style;
    }
    public void setId_style(int id_style) {
        this.id_style = id_style;
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

    public Quantite[] getAllQuantite(Connection c, int id_materiel)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            java.sql.Statement st = c.createStatement();
            String sql = "select * from Quantite where id_materiel=";
            ResultSet res = st.executeQuery(sql);
            List<Quantite> allF = new ArrayList<>();
            while (res.next()) {
                allF.add(new Quantite(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getDouble(6)));
            }
            Quantite[] all = new Quantite[allF.size()];
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
