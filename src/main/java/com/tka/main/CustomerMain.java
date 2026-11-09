package com.tka.main;

import java.util.Arrays;
import java.util.List;

import com.tka.dao.CustomerDAO;
import com.tka.daoImpl.CustomerDaoImpl;
import com.tka.entity.Customer;

public class CustomerMain {

    public static void main(String[] args) {

        CustomerDAO customerdao = new CustomerDaoImpl();

        List<Customer> customer_list;

        /*
        customer_list = customerdao.searchCustomerByCity("Pune");
        customer_list.forEach(c -> System.out.println(c));

        customer_list = customerdao.searchCustomerByName("Rahul");
        customer_list.forEach(c -> System.out.println(c));

        customer_list = customerdao.searchCustomerByMobile("9876543210");
        customer_list.forEach(c -> System.out.println(c));

        customer_list = customerdao.searchCustomerByCityNotEqual("Mumbai");
        customer_list.forEach(c -> System.out.println(c));

        customer_list = customerdao.searchCustomerByNameStartWith("R");
        customer_list.forEach(c -> System.out.println(c));

        List<String> names = Arrays.asList("Rahul", "Priya");
        customer_list = customerdao.searchCustomerByNames(names);
        customer_list.forEach(c -> System.out.println(c));

        customer_list = customerdao.searchCustomerByCityAndName("Pune", "Rahul");
        customer_list.forEach(c -> System.out.println(c));

        customer_list = customerdao.searchCustomerByNameNotIn(names);
        customer_list.forEach(c -> System.out.println(c));

        customer_list = customerdao.getCustomerList();
        customer_list.forEach(c -> System.out.println(c));
        */

        System.out.println("Highest ID Customer: "
                + customerdao.getHighestIdCustomer());

        System.out.println("Lowest ID Customer: "
                + customerdao.getLowestIdCustomer());

        System.out.println("Second Highest ID Customer: "
                + customerdao.getSecondHighestIdCustomer());

        System.out.println("Second Lowest ID Customer: "
                + customerdao.getSecondLowestIdCustomer());
    }
}