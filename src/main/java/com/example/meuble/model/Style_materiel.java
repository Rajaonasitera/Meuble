package com.example.meuble.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.meuble.connection.Connect;

public class Style_materiel {
    int id_style_materiel;
    int id_style;
    int id_materiel;
    
    public Style_materiel(int id_style_materiel, int id_style, int id_materiel) {
        this.id_style_materiel = id_style_materiel;
        this.id_style = id_style;
        this.id_materiel = id_materiel;
    }
    public Style_materiel() {
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
    public int getId_materiel() {
        return id_materiel;
    }
    public void setId_materiel(int id_materiel) {
        this.id_materiel = id_materiel;
    }

    public Style_materiel[] getAllMateriel(Connection c,int id_style)throws  Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Style_materiel> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from style_materiel where id_style="+id_style;
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS.add(new Style_materiel(res.getInt(1),res.getInt(2),res.getInt(3)));
            }
            Style_materiel[] all = new Style_materiel[allS.size()];
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

    public Style_materiel[] getAllMaterielById(Connection c,int id_materiel)throws  Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Style_materiel> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from style_materiel where id_materiel="+id_materiel;
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS.add(new Style_materiel(res.getInt(1),res.getInt(2),res.getInt(3)));
            }
            Style_materiel[] all = new Style_materiel[allS.size()];
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

    public Style_materiel[] getAllStyleMateriel(Connection c)throws  Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Style_materiel> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "select * from style_materiel";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                allS.add(new Style_materiel(res.getInt(1),res.getInt(2),res.getInt(3)));
            }
            Style_materiel[] all = new Style_materiel[allS.size()];
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

    public Style_materiel getAllStyleMaterielById(Connection c,int id)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Style_materiel[] allSM = this.getAllStyleMateriel(c);
            for (int i = 0; i < allSM.length; i++) {
                if (allSM[i].getId_style_materiel()==id){
                    return allSM[i];
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // TODO: handle exception
        }finally{
            if (coTest==true)
                c.close();
        }
    }

    public void insertStyleMateriel(Connection c, int idStyle, int idMateriel)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            List<Style> allS = new ArrayList<>();
            java.sql.Statement st = c.createStatement();
            String sql = "insert into style_materiel(id_style,id_materiel) values("+idStyle+","+idMateriel+")";
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

    public Boolean verification(Connection c,int idStyle,int idMateriel)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            
            Style_materiel[] all = this.getAllStyleMateriel(c);
            for (int i = 0; i < all.length; i++) {
                if (all[i].getId_style()==idStyle&&all[i].getId_materiel()==idMateriel) {
                    return true;
                }
            }
            return false;
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
