package org.smart4j.chapter2.controller;

import org.apache.commons.lang3.StringUtils;
import org.smart4j.chapter2.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangz on 2017/8/8.
 */
@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet {
    /**
     * get请求返回页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Customer customer = null;
        if(StringUtils.isNotEmpty(id)){
            //TODO GET DATA FROM DATABASE
        }

        req.setAttribute("customer", customer);

        req.getRequestDispatcher("/WEB-INF/jsp/customer_create.jsp").forward(req, resp);

    }

    /**
     * post请求提交数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String  contact = req.getParameter("contact");
        String telephone = req.getParameter("telephone");
        String email = req.getParameter("email");
        String remark = req.getParameter("remark");
        Customer customer = new Customer();
        if( StringUtils.isNotEmpty(id)){
            customer.setId(Long.parseLong(id));
        }
        customer.setContact(contact);
        customer.setName(name);
        customer.setTelephone(telephone);
        customer.setEmail(email);
        customer.setRemark(remark);
        //TODO save or update cosutomer info

        PrintWriter out = resp.getWriter();
        out.write("成功");
        out.close();
    }
}
