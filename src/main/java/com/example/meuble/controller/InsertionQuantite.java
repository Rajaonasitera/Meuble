package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Fabrication;
import com.example.meuble.model.Style_materiel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "InsertionQuantite", value = "/InsertionQuantite")
public class InsertionQuantite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            int idStyleMateriel = Integer.parseInt(request.getParameter("stylemateriaux"));
            int idCategorie = Integer.parseInt(request.getParameter("categorie"));
            int idVolume = Integer.parseInt(request.getParameter("volume"));
            double quantite = Double.parseDouble(request.getParameter("quantite"));
            Fabrication f = new Fabrication();
            f.insertionQuantite(c,idStyleMateriel,idCategorie,idVolume,quantite);
            String lien = "Insertion_quantite";
            response.sendRedirect(lien);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
