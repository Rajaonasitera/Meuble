package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Meuble;
import com.example.meuble.model.Style;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "InsertionMeuble", value = "/InsertionMeuble")
public class InsertionMeuble extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            int idStyle = Integer.parseInt(request.getParameter("style"));            
            int idCategorie = Integer.parseInt(request.getParameter("categorie"));
            int idVolume = Integer.parseInt(request.getParameter("volume"));
            double prix = Double.parseDouble(request.getParameter("prix"));
            Meuble m = new Meuble();
            m.insertMeuble(c, idCategorie, idStyle, idVolume, prix);
            String lien = "PageInsertionMeuble";
            response.sendRedirect(lien);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
