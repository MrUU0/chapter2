package org.smart4j.chapter2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;
import org.smart4j.chapter2.utils.PropsUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by wangz on 2017/8/8.
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);

    private CustomerService service;
    @Override
    public void init() throws ServletException {
        service = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> resList = service.getCustomerList( null);
        req.setAttribute("customerList", resList);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
