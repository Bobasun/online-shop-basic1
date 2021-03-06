package com.study.onlineshop.web.servlet;

import com.study.onlineshop.service.ProductService;
import com.study.onlineshop.service.ServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: add delete product mapping on POST request to /product/delete/* where * is product id
public class DeleteProductServlet extends HttpServlet {
    private ProductService productService = (ProductService) ServiceLocator.getService("productService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        int index = uri.lastIndexOf("/");
        int id = Integer.valueOf(uri.substring(index + 1, uri.length()));
        productService.delete(id);
        resp.sendRedirect("/products");
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
