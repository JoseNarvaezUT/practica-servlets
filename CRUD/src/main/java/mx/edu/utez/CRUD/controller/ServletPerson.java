package mx.edu.utez.CRUD.controller;

import mx.edu.utez.CRUD.model.DaoPerson;
import mx.edu.utez.CRUD.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletPerson", value = "/ServletPerson")
public class ServletPerson extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletPerson.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("person", new DaoPerson().finbById(id));
            request.getRequestDispatcher("/WEB-INF/view/person.jsp").forward(request, response);
        } else {
            request.setAttribute("listPersons", new DaoPerson().findAll());
            request.getRequestDispatcher("/WEB-INF/view/persons.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String edadS = request.getParameter("age") != null ?
                request.getParameter("age") : "0";
        String name = request.getParameter("name") != null ?
                request.getParameter("name") : "-";
        int edad = 0;
        try {
            edad = Integer.parseInt(edadS);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        Person aPerson = new Person(0, name, edad);
        if (new DaoPerson().save(aPerson)) {
            request.setAttribute("mensaje", "Persona registrada");
        } else {
            request.setAttribute("mensaje", "Error al registrar");
        }
        doGet(request, response);
    }
}
