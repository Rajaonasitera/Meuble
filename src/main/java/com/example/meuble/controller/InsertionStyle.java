package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Style;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "InsertionStyle", value = "/InsertionStyle")
public class InsertionStyle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            String libelle = request.getParameter("libelle");
            Style s = new Style();
            s.insertStyle(c, libelle);
            String lien = "Insertion_style";
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
