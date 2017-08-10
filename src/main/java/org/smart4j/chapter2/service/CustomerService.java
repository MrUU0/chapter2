package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.controller.CustomerServlet;
import org.smart4j.chapter2.helper.DBHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.utils.CastUtil;
import org.smart4j.chapter2.utils.PropsUtil;
import org.smart4j.chapter2.utils.StringUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by wangz on 2017/8/8.
 */
public class CustomerService {

    private static  final Logger logger = LoggerFactory.getLogger(CustomerServlet.class);


    /**
     * query by keyword
     * @param keyWord
     * @return
     */
    public List<Customer> getCustomerList( String keyWord){
        try {
            List<Customer> resList = null;
            String sql = "SELECT * FROM CUSTOMER";
            if(StringUtil.isEmpty(keyWord)){
                resList = DBHelper.queryList(Customer.class,sql);
            }else {
                resList = DBHelper.queryList(Customer.class,sql+" WHERE NAME LIKE '%?%'", keyWord);
            }
            return resList;
        } catch (Exception e) {
            logger.error("[getCustomerList] execute sql failure", e);
        }
        return null;
    }

    /**
     * query customer by id
     * @param id
     * @return
     */
    public Customer getCustomer( long id){
        return DBHelper.queryEntity( Customer.class, "SELECT * FROM CUSTOMER WHERE ID = ?", id);
    }

    /**
     * create customer
     * @param params
     * @return
     */
    public boolean createCustomer(Map<String, Object> params){
        return DBHelper.insertEntity(Customer.class, params);
    }

    /**
     * update customer info
     * @param id
     * @param params
     * @return
     */
    public boolean updateCustomer( long id, Map<String, Object> params){
        params.put("ID",id);
        return DBHelper.updateEntity(Customer.class, params);
    }

    /**
     * delete customer by id
     * @param id
     * @return
     */
    public boolean deleteCustomer( long id){
        return DBHelper.deleteEntity(Customer.class, id);
    }

}
