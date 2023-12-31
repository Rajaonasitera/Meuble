package com.example.meuble.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.meuble.connection.Connect;

public class Materiel {
    int id_materiel;
    String libelle;
    int unite;

    public Materiel(int id_materiel, String libelle, int unite) {
        this.id_materiel = id_materiel;
        this.libelle = libelle;
        this.unite = unite;
    }
    public int getUnite() {
        return unite;
    }
    public void setUnite(int unite) {
        this.unite = unite;
    }
    
    public Materiel() {
    }
    public int getId_materiel() {
        return id_materiel;
    }
    public void setId_materiel(int id_materiel) {
        this.id_materiel = id_materiel;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Materiel getMaterielById(Connection c, int id_materiel)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            List<Materiel> allS = new ArrayList<>();
            Statement st = c.createStatement();
            String sql = "select * from Materiel where id_materiel="+id_materiel;
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS.add(new Materiel(res.getInt(1),res.getString(2),res.getInt(3)));
            }
            return allS.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public Materiel[] getAllMateriel(Connection c)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            List<Materiel> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from Materiel";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS.add(new Materiel(res.getInt(1),res.getString(2),res.getInt(3)));
            }
            Materiel[] all = new Materiel[allS.size()];
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
    public Materiel getMateriel(Connection c, int id_Materiel)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            Materiel allS = new Materiel();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from Materiel where id_Materiel ="+id_Materiel;
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS= new Materiel(res.getInt(1),res.getString(2),res.getInt(3));
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

    public void insertMateriel(Connection c, String libelle, int idUnite)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed())
                c = (new Connect()).connecter();
                coTest = true;
            List<Style> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "insert into materiel(libelle) values('"+libelle+"',"+idUnite+")";
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
