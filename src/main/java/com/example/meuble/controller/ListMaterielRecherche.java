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

@WebServlet(name = "ListMaterielRecherche", value = "/ListMaterielRecherche")
public class ListMaterielRecherche extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            Materiel m = new Materiel();
            Materiel[] allM = m.getAllMateriel(c);
            request.setAttribute("materiel", allM);
            String lien = "checkMatiere";
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
