package ru.job4j.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.model.*;
import ru.job4j.store.Hiber;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            Mark mark = new Mark();
            String model = null;
            BodyType body = new BodyType();
            Color color = new Color();
            int year = 0;
            int price = 0;
            String description = null;
            List<Photo> photos = new ArrayList<>();

            List<FileItem> items = upload.parseRequest(req);
            File folder = new File("c:\\images\\");
            if (!folder.exists()) {
                folder.mkdir();
            }
            String parameter;
            String value;
            for (FileItem item : items) {
                if (!item.isFormField() && item.getSize() != 0) {
                    photos.add(new Photo(item.getName()));
                    File file = new File(folder + File.separator + item.getName());
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        out.write(item.getInputStream().readAllBytes());
                    }
                } else {
                    parameter = item.getFieldName();
                    value = item.getString("UTF-8");
                    if ("mark".equals(parameter)) {
                        mark.setId(Integer.parseInt(value));
                    } else if ("modeles".equals(parameter)) {
                        model = value;
                    } else if ("body".equals(parameter)) {
                        body.setId(Integer.parseInt(value));
                    } else if ("color".equals(parameter)) {
                        color.setId(Integer.parseInt(value));
                    } else if ("year".equals(parameter)) {
                        year = Integer.parseInt(value);
                    } else if ("price".equals(parameter)) {
                        price = Integer.parseInt(value);
                    } else if ("description".equals(parameter)) {
                        description = value;
                    }
                }
            }
            if (photos.isEmpty()) {
                photos.add(new Photo("no_photo.png"));
            }

            User user = (User) req.getSession().getAttribute("user");
            Car car = new Car(year, price, model, color, mark, body);
            Item item = new Item(description, new Date(), false, user, car, photos);
            Hiber.instOf().saveItem(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("marks", Hiber.instOf().marksAll());
        req.setAttribute("bodies", Hiber.instOf().bodyTypesAll());
        req.setAttribute("colors", Hiber.instOf().colorsAll());
        req.getRequestDispatcher("item.jsp").forward(req, resp);
    }
}
