package com.example.meuble.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.meuble.connection.Connect;

public class Fabrication {
    int id_fabrication;
    int id_categorie;
    int id_style;
    int id_materiel;
    int id_volume;
    double quantite;
    public Fabrication(int id_fabrication, int id_categorie, int id_style, int id_materiel, int id_volume,
            double quantite) {
        this.id_fabrication = id_fabrication;
        this.id_categorie = id_categorie;
        this.id_style = id_style;
        this.id_materiel = id_materiel;
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
    public int getId_materiel() {
        return id_materiel;
    }
    public void setId_materiel(int id_materiel) {
        this.id_materiel = id_materiel;
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

    public void insertionQuantite(Connection c, int id_categorie, int id_style, int id_materiel, int id_volume, double quantite)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Style> allS = new ArrayList<>();
            Statement st = c.createStatement();
            Style_materiel sm = new Style_materiel();
            if (sm.verification(c, id_style, id_materiel)==true) {
                String sql = "insert into fabrication(id_categorie,id_style,id_materiel,id_volume,quantite) values("+id_categorie+","+id_style+","+id_materiel+","+id_volume+","+quantite+")";
                int ok = st.executeUpdate(sql);
            }else{
                throw new Exception("Materiel pas compatible style");
            }
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
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Style> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from fabrication";
            ResultSet res = st.executeQuery(sql);
            List<Fabrication> allF = new ArrayList<>();
            while (res.next()) {
                allF.add(new Fabrication(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5),res.getDouble(6)));
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

    public Fabrication[] recherche(Connection c, int id_materiel)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Fabrication[] allF = this.getAllFabrication(c);
            List<Fabrication> all = new ArrayList<>();
            for (int i = 0; i < allF.length; i++) {
                if (allF[i].getId_materiel()==id_materiel) {
                    all.add(allF[i]);
                }
            }
            Fabrication[] reponse = new Fabrication[all.size()];
            return all.toArray(reponse);
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
