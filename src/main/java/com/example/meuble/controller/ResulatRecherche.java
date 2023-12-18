package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Fabrication;
import com.example.meuble.model.Materiel;
import com.example.meuble.model.Quantite;
import com.example.meuble.model.Style;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "ResulatRecherche", value = "/ResulatRecherche")
public class ResulatRecherche extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect co = new Connect();
            Connection c = co.connecter();
            Fabrication f = new Fabrication();
            Quantite q = new Quantite();
            Quantite[] allQ = q.ge
            Fabrication[] allF = f.g
            Style s = new Style();
            Materiel m = new Materiel();
            Style[] allS = s.getAllStyle(c);
            Materiel[] allM = m.getAllMateriel(c);
            request.setAttribute("style", allS);
            request.setAttribute("materiel", allM);
            String lien = "Insertion_stylemateriaux";
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
