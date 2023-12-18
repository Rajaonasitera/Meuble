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
            Style_materiel[] allSM = sm.getAllStyleMateriel(c);
            Categorie[] allC = ca.getAllCategorie(c);
            Volume[] allV = vo.getAllVolume(c);
            Style[] allSt = new Style[allSM.length];
            Materiel[] allM = new Materiel[allSM.length];
            for (int i = 0; i < allSM.length; i++) {
                allSt[i] = s.getStyleById(c,allSt[i].getId_style());
                allM[i] = m.getMateriel(c,allSM[i].getId_materiel());
            }
            request.setAttribute("allSM", allSM);
            request.setAttribute("allC", allC);
            request.setAttribute("allV", allV);
            request.setAttribute("allM", allM);
            request.setAttribute("allSt", allSt);
            String lien = "Insertion_quantite";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(lien+".jsp");
            requestDispatcher.forward(request,response);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
