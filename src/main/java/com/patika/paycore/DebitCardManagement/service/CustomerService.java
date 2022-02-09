package com.patika.paycore.DebitCardManagement.service;

import com.patika.paycore.DebitCardManagement.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomer(Integer id);

    void addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    boolean deleteCustomer(Integer id);

    List<Customer> getCustomersNameStartsWith(String prefix);

    List<Customer> getCustomersSortedViaLastNameAsUpperCase();

}
