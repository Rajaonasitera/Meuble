package com.example.meuble.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.meuble.connection.Connect;
public class FabricationMeuble
{
    int id_fabrication;
    int id_meuble;
    int id_categorie;
    int id_style;
    int id_volume;
    int id_materiel;
    double quantite;
    public int getId_fabrication()
    {
        return this.id_fabrication;
    }
    public void setId_fabrication(int id_fabrication)
    {
        this.id_fabrication=id_fabrication;
    }
    public int getId_meuble()
    {
        return this.id_meuble;
    }
    public void setId_meuble(int id_meuble)
    {
        this.id_meuble=id_meuble;
    }
    public int getId_categorie()
    {
        return this.id_categorie;
    }
    public void setId_categorie(int id_categorie)
    {
        this.id_categorie=id_categorie;
    }
    public int getId_style()
    {
        return this.id_style;
    }
    public void setId_style(int id_style)
    {
        this.id_style=id_style;
    }
    public int getId_volume()
    {
        return this.id_volume;
    }
    public void setId_volume(int id_volume)
    {
        this.id_volume=id_volume;
    }
    public int getId_materiel()
    {
        return this.id_materiel;
    }
    public void setId_materiel(int id_materiel)
    {
        this.id_materiel=id_materiel;
    }
    public double getQuantite()
    {
        return this.quantite;
    }
    public void setQuantite(double quantite)
    {
        this.quantite=quantite;
    }
}