package com.example.meuble.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Style;

@WebServlet(name = "PageInsertionStyle", value = "/PageInsertionStyle")
public class PageInsertionStyle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lien = "Insertion_style.jsp";
        response.sendRedirect(lien);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
