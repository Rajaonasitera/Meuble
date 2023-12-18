package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Categorie;
import com.example.meuble.model.Materiel;
import com.example.meuble.model.Style;
import com.example.meuble.model.Volume;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "PageInsertionMeuble", value = "/PageInsertionMeuble")
public class PageInsertionMeuble extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            Style s = new Style();
            Materiel m = new Materiel();
            Volume v = new Volume();
            Categorie ca = new Categorie();
            Style[] allS = s.getAllStyle(c);
            Categorie[] allC = ca.getAllCategorie(c);
            Volume[] allV = v.getAllVolume(c);
            request.setAttribute("style", allS);
            request.setAttribute("categorie", allC);            
            request.setAttribute("volume", allV);
            String lien = "Insertion_meuble";
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
