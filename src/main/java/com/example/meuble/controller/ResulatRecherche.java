package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.*;
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
             int idMatiere = Integer.parseInt(request.getParameter("materiel"));
             AffichageQuantite aq = new AffichageQuantite();
             AffichageQuantite[] allAQ = aq.getAffichageQuantite(c,idMatiere);
             request.setAttribute("allAQ", allAQ);
             String lien = "ListeMeublesQtte";
             RequestDispatcher requestDispatcher = request.getRequestDispatcher(lien+".jsp");
             requestDispatcher.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
