package com.example.meuble.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.meuble.connection.Connect;

public class Categorie {
    int id_categorie;
    String libelle;

    public Categorie(int id_categorie, String libelle) {
        this.id_categorie = id_categorie;
        this.libelle = libelle;
    }
    public Categorie() {
    }
    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie[] getAllCategorie(Connection c)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Categorie> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from Categorie";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS.add(new Categorie(res.getInt(1),res.getString(2)));
            }
            Categorie[] all = new Categorie[allS.size()];
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

    public Categorie getCategorie(Connection c, int id_categorie)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Categorie allS = new Categorie();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from Categorie where id_catergorie ="+id_categorie;
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS= new Categorie(res.getInt(1),res.getString(2));
            }
            return allS;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

     public void insertCategorie(Connection c, String libelle)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Style> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "insert into categorie(libelle) values('"+libelle+"')";
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
