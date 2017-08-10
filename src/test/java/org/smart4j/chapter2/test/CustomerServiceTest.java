package org.smart4j.chapter2.test;

import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.helper.DBHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangz on 2017/8/8.
 */

public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }

    @Before
    public void init() throws Exception{
        String file = "sql/customer_init.sql";
        DBHelper.executeSqlFile(file);
    }

    @Test
    public void getCustomerListTest(){
        List<Customer> list = customerService.getCustomerList("");
        for( Customer customer : list){
            System.out.println(customer.toString());
        }
        System.out.println("=========== end ============");
    }

    /**
     * query customer by id
     */
    @Test
    public void testGetCustomer(){
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        System.out.println(customer);
        assert ( customer != null);
    }

    /**
     * create customer
     */
    @Test
    public void testCreateCustomer(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id","123");
        params.put("name","name 1");
        params.put("contact","contact");
        params.put("email","email");
        params.put("telephone","telephone");
        params.put("remark","remark");
        boolean flag = customerService.createCustomer(params);
    }

    /**
     * update customer info
     */
    @Test
    public void testUpdateCustomer( ){
        long id = 1;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id","1");
        params.put("name","name 1");
        params.put("contact","contact");
        params.put("email","email");
        params.put("telephone","telephone");
        params.put("remark","remark");
        customerService.updateCustomer(id, params);
    }

    /**
     * delete customer by id
     */
    @Test
    public void testDeleteCustomer( ){
        long id = 1;
        customerService.deleteCustomer(id);
    }

}
