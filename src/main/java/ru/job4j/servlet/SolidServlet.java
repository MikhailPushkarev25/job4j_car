package ru.job4j.servlet;

import ru.job4j.store.Hiber;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SolidServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        Hiber.instOf().updateItem(itemId);
        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
