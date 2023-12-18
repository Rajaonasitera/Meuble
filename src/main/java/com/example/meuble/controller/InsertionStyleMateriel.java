package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Categorie;
import com.example.meuble.model.Style_materiel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "InsertionStyleMateriel", value = "/InsertionStyleMateriel")
public class InsertionStyleMateriel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            int idStyle = Integer.parseInt(request.getParameter("style"));
            int idMateriel = Integer.parseInt(request.getParameter("materiel"));

            Style_materiel sm = new Style_materiel();
            sm.insertStyleMateriel(c,idStyle,idMateriel);
            String lien = "PageInsertionStyleMateriel";
            response.sendRedirect(lien);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
