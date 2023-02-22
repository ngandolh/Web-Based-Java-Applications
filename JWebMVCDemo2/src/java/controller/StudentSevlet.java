/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import model.Student;

/**
 *
 * @author ACER
 */
@WebServlet(name = "Student", urlPatterns = {"/student"})
public class StudentSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int num = Integer.parseInt(request.getParameter("num"));
            ArrayList<Student> list = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                int size = randomInt(3, 7);
                String name = randomText(size);
                Date date = randomDate();
                Student st = new Student(i, name, randomBool(), date);
                list.add(st);
            }
            request.setAttribute("num", num);
            request.setAttribute("list", list);
            request.getRequestDispatcher("student.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    int randomInt(int min, int max) {
        Random r = new Random();
        int x = r.nextInt(max - min + 1) + min;
        return x;
    }

    String randomText(int size) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        String text = "";
        for (int i = 1; i <= size; i++) {
            text += AlphaNumericString.charAt(randomInt(0, AlphaNumericString.length() - 1));
        }
        return text;
    }

    Boolean randomBool() {
        Random r = new Random();
        return r.nextBoolean();
    }

    Date randomDate() {
        int year = randomInt(1980, 2010);
        int month = randomInt(1, 12);
        int day = randomInt(1, 28);
        String date_String = "" + day + "/" + month + "/" + year;
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date_String);
        } catch (ParseException e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
