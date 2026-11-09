package com.tka.dao;

import java.util.List;
import com.tka.entity.Customer;

public interface CustomerDAO {

    public void insertCustomer(Customer customer);

    public List<Customer> searchCustomerByCity(String city);

    public List<Customer> searchCustomerByName(String name);

    public List<Customer> searchCustomerByMobile(String mobile);

    public List<Customer> searchCustomerByCityNotEqual(String city);

    public List<Customer> searchCustomerByNameStartWith(String name);

    public List<Customer> searchCustomerByNames(List<String> names);

    public List<Customer> searchCustomerByCityAndName(String city, String name);

    public List<Customer> searchCustomerByNameNotIn(List<String> names);

    public List<Customer> getCustomerList();

    public Customer getHighestIdCustomer();

    public Customer getLowestIdCustomer();

    public Customer getSecondHighestIdCustomer();

    public Customer getSecondLowestIdCustomer();
}