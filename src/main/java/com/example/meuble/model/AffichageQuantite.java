package com.example.meuble.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.example.meuble.connection.Connect;

public class AffichageQuantite {
    Categorie categorie;
    Style style;
    Materiel materiel;
    Volume volume;
    double quantite;

    public AffichageQuantite(Categorie categorie, Style style, Materiel materiel, Volume volume, double quantite) {
        this.categorie = categorie;
        this.style = style;
        this.materiel = materiel;
        this.volume = volume;
        this.quantite = quantite;
    }
    public AffichageQuantite() {
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    public Style getStyle() {
        return style;
    }
    public void setStyle(Style style) {
        this.style = style;
    }
    public Materiel getMateriel() {
        return materiel;
    }
    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }
    public Volume getVolume() {
        return volume;
    }
    public void setVolume(Volume volume) {
        this.volume = volume;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public AffichageQuantite[] getAffichageQuantite(Connection c, int id_materiel)throws Exception{
        Boolean coTest = false;
        try {
            if (c==null||c.isClosed()){
                c = (new Connect()).connecter();
                coTest = true;}
            Fabrication f = new Fabrication();
            Fabrication[] allF = f.recherche(c, id_materiel);
            Categorie ca = new Categorie();
            Style s = new Style();
            Materiel m = new Materiel();
            Volume v = new Volume();
            List<AffichageQuantite> all = new ArrayList<>();
            for (int i = 0; i < allF.length; i++) {
                ca = ca.getCategorie(c, allF[i].getId_categorie());
                s = s.getStyleById(c, allF[i].getId_style());
                m = m.getMaterielById(c, allF[i].getId_materiel());
                v = v.getVolume(c, allF[i].getId_volume());
                all.add(new AffichageQuantite(ca, s, m, v, allF[i].getQuantite()));
            }
            AffichageQuantite[] reponse = new AffichageQuantite[all.size()];
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
