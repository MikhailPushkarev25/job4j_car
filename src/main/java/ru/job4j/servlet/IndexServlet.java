package ru.job4j.servlet;

import ru.job4j.model.Item;
import ru.job4j.store.Hiber;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> itemList = Hiber.instOf().itemJoin();
        req.setAttribute("items", itemList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
