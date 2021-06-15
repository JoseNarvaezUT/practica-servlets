package mx.edu.utez.CRUD.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "ServletPrueba", value = "/ServletPrueba")
public class ServletPrueba extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer w = response.getWriter();
        response.setContentType("text/html");
        w.write("<html>" +
                "<body>" +
                "<h1>Sofxicalco Hola Cesss</h1>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
