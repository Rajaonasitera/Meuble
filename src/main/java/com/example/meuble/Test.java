package com.example.meuble;

import com.example.meuble.connection.Connect;
import com.example.meuble.model.Style;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) throws  Exception{
        Connect co = new Connect();
        Connection c = co.connecter();
        Style s = new Style();
        Style[] st = s.getAllStyle(c);
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i].getLibelle());
        }
    }
}
