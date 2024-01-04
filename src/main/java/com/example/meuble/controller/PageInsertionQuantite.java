package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PageInsertionQuantite", value = "/PageInsertionQuantite")
public class PageInsertionQuantite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            Style_materiel sm = new Style_materiel();
            Categorie ca = new Categorie();
            Volume vo = new Volume();
            Style s = new Style();
            Materiel m = new Materiel();
            Categorie[] allC = ca.getAllCategorie(c);
            Volume[] allV = vo.getAllVolume(c);
            Style_materiel[] allSM = sm.getAllStyleMateriel(c);
            List<Style> allS = new ArrayList<>();
            List<Materiel> allM = new ArrayList<>();
            
            for (int i = 0; i < allSM.length; i++) {
                allS.add(s.getStyleById(c, allSM[i].getId_style()));
                allM.add(m.getMaterielById(c, allSM[i].getId_materiel()));
            }

            Style[] alls = new Style[allS.size()];
            Materiel[] allm = new Materiel[allM.size()];

            request.setAttribute("allS", allS.toArray(alls));
            request.setAttribute("allC", allC);
            request.setAttribute("allV", allV);
            request.setAttribute("allM", allM.toArray(allm));
            request.setAttribute("allSM", allSM);

            String lien = "Insertion_quantite";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(lien+".jsp");
            requestDispatcher.forward(request,response);

        }catch(Exception e){
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
