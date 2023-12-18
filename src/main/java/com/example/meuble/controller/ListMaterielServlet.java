package com.example.meuble.controller;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Materiel;
import com.example.meuble.model.Style;
import com.example.meuble.model.Style_materiel;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListMaterielServlet", value = "/ListMaterielServlet")
public class ListMaterielServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idStyle = Integer.parseInt(request.getParameter("style"));
            Connect co = new Connect();
            Connection c = co.connecter();
            Style_materiel sm = new Style_materiel();
            Style_materiel[] allSM = sm.getAllMateriel(c,idStyle);
            Materiel m = new Materiel();
            Style s = new Style();
            s = s.getStyleById(c,idStyle);
            List<Materiel> allM = new ArrayList<>();
            for (int i = 0; i < allSM.length; i++) {
                allM.add(m.getMaterielById(c,allSM[i].getId_materiel()));
            }
            Materiel[] all = new Materiel[allM.size()];
            request.setAttribute("materiaux",allM.toArray(all));
            request.setAttribute("style",s);
            String lien = "ListeMeuble";
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
