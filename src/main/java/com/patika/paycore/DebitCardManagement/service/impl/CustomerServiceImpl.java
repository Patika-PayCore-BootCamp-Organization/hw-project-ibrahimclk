package com.patika.paycore.DebitCardManagement.service.impl;

import com.patika.paycore.DebitCardManagement.exception.NotFoundException;
import com.patika.paycore.DebitCardManagement.model.Customer;
import com.patika.paycore.DebitCardManagement.repository.CustomerRepository;
import com.patika.paycore.DebitCardManagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Integer id) {
        Optional<Customer> byId = customerRepository.findById(id);
        return byId.orElseThrow(() -> new NotFoundException("Customer"));
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(Integer id) {
        customerRepository.delete(getCustomer(id));
        return true;
    }

    // Java8 Playground
    @Override
    public List<Customer> getCustomersNameStartsWith(String prefix) {
        List<Customer> allCustomers = getAllCustomers();
        return allCustomers.stream()
                .filter(p -> p.getFirstname().startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getCustomersSortedViaLastNameAsUpperCase() {
        List<Customer> allCustomers = getAllCustomers();
        return allCustomers.stream()
                .sorted(Comparator.comparing(Customer::getLastname))
                .peek(p -> p.setLastname(p.getLastname().toUpperCase()))
                .collect(Collectors.toList());
    }

    private Customer getTheOldestMaleCustomerAndLowerCaseFirstLast() {
        List<Customer> allCustomers = getAllCustomers();
        return allCustomers.stream()
                .max(Comparator.comparing(Customer::getAge))
                .filter(p -> p.getGender().equals("male"))
                .orElseThrow(() -> new NotFoundException("No matching passenger"));
    }

    private Boolean isAnyCustomerLastNameStartsWithCharAndFemale(String prefix) {
        List<Customer> allCustomers = getAllCustomers();
        return allCustomers.stream()
                .anyMatch(p -> p.getLastname().startsWith(prefix) && p.getGender().equals("female"));
    }

    private Boolean isAllCustomerFemaleAndAgeBetween(Integer minAge, Integer maxAge) {
        List<Customer> allCustomers = getAllCustomers();
        return allCustomers.stream()
                .allMatch(p -> p.getGender().equals("female") && (p.getAge() > minAge && p.getAge() < maxAge));
    }

    private Boolean isNoneCustomerFirstNameAndPhoneStartsWith(String firstName, String phonePrefix) {
        List<Customer> allCustomers = getAllCustomers();
        return allCustomers.stream()
                .noneMatch(p -> p.getFirstname().equals(firstName) && p.getPhone().startsWith(phonePrefix));
    }

    private Integer getCountOfMaleCustomersAgeBetween(Integer minAge, Integer maxAge) {
        List<Customer> allCustomers = getAllCustomers();
        return (int) allCustomers.stream()
                .filter(p -> p.getGender().equals("male") && (p.getAge() > minAge && p.getAge() < maxAge))
                .count();
    }

    private List<String> getCustomerListAsFirstNameAndLastName() {
        List<Customer> allCustomers = getAllCustomers();
        return allCustomers.stream()
                .map(p -> p.getFirstname() + " " + p.getLastname())
                .collect(Collectors.toList());
    }

}
