package com.tka.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.tka.dao.CustomerDAO;
import com.tka.entity.Customer;

public class CustomerDaoImpl implements CustomerDAO {

    private Session getSession() {
        return new Configuration().configure()
                .buildSessionFactory().openSession();
    }

    @Override
    public void insertCustomer(Customer customer) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
        session.close();

        System.out.println("Customer Data Saved...");
    }

    public List<Customer> searchCustomerByCity(String city) {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .add(Restrictions.eq("city", city)).list();

        session.close();
        return list;
    }

    public List<Customer> searchCustomerByName(String name) {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .add(Restrictions.eq("name", name)).list();

        session.close();
        return list;
    }

    public List<Customer> searchCustomerByMobile(String mobile) {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .add(Restrictions.eq("mobile", mobile)).list();

        session.close();
        return list;
    }

    public List<Customer> searchCustomerByCityNotEqual(String city) {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .add(Restrictions.ne("city", city)).list();

        session.close();
        return list;
    }

    public List<Customer> searchCustomerByNameStartWith(String name) {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .add(Restrictions.like("name", name + "%")).list();

        session.close();
        return list;
    }

    public List<Customer> searchCustomerByNames(List<String> names) {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .add(Restrictions.in("name", names)).list();

        session.close();
        return list;
    }

    public List<Customer> searchCustomerByCityAndName(String city, String name) {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .add(Restrictions.and(
                        Restrictions.eq("city", city),
                        Restrictions.eq("name", name)))
                .list();

        session.close();
        return list;
    }

    public List<Customer> searchCustomerByNameNotIn(List<String> names) {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .add(Restrictions.not(Restrictions.in("name", names))).list();

        session.close();
        return list;
    }

    public List<Customer> getCustomerList() {
        Session session = getSession();

        List<Customer> list = session.createCriteria(Customer.class)
                .addOrder(Order.desc("id")).list();

        session.close();
        return list;
    }

    public Customer getHighestIdCustomer() {
        Session session = getSession();

        Customer customer = (Customer) session.createCriteria(Customer.class)
                .addOrder(Order.desc("id"))
                .setMaxResults(1).uniqueResult();

        session.close();
        return customer;
    }

    public Customer getLowestIdCustomer() {
        Session session = getSession();

        Customer customer = (Customer) session.createCriteria(Customer.class)
                .addOrder(Order.asc("id"))
                .setMaxResults(1).uniqueResult();

        session.close();
        return customer;
    }

    public Customer getSecondHighestIdCustomer() {
        Session session = getSession();

        Integer maxId = (Integer) session.createCriteria(Customer.class)
                .setProjection(org.hibernate.criterion.Projections.max("id"))
                .uniqueResult();

        Customer customer = null;

        if (maxId != null) {
            customer = (Customer) session.createCriteria(Customer.class)
                    .add(Restrictions.lt("id", maxId))
                    .addOrder(Order.desc("id"))
                    .setMaxResults(1).uniqueResult();
        }

        session.close();
        return customer;
    }

    public Customer getSecondLowestIdCustomer() {
        Session session = getSession();

        Integer minId = (Integer) session.createCriteria(Customer.class)
                .setProjection(org.hibernate.criterion.Projections.min("id"))
                .uniqueResult();

        Customer customer = null;

        if (minId != null) {
            customer = (Customer) session.createCriteria(Customer.class)
                    .add(Restrictions.gt("id", minId))
                    .addOrder(Order.asc("id"))
                    .setMaxResults(1).uniqueResult();
        }

        session.close();
        return customer;
    }
}