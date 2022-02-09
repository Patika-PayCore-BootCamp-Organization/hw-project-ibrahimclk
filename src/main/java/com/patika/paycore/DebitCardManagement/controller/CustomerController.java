package com.patika.paycore.DebitCardManagement.controller;


import com.patika.paycore.DebitCardManagement.exception.InvalidRequestException;
import com.patika.paycore.DebitCardManagement.model.Customer;
import com.patika.paycore.DebitCardManagement.model.CustomerDTO;
import com.patika.paycore.DebitCardManagement.model.mapper.CustomerMapper;
import com.patika.paycore.DebitCardManagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private static final CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    @GetMapping
    public String welcome() {
        return "Welcome to Customer Service!";
    }

    @GetMapping(value = "/all")
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return allCustomers.stream().map(CUSTOMER_MAPPER::toDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public CustomerDTO getCustomer(@PathVariable @Min(1) Integer id) {
        return CUSTOMER_MAPPER.toDto(customerService.getCustomer(id));
    }

    @PostMapping(value = "/create")
    public void saveCustomer(@Valid @RequestBody CustomerDTO customer) {
        customerService.addCustomer(CUSTOMER_MAPPER.toEntity(customer));
    }

    @PutMapping(value = "/update")
    public CustomerDTO updateCustomer(@Valid @RequestBody Customer customer) {
        if (customer.getId() == null) {
            throw new InvalidRequestException("Customer id can not be null for update!");
        }
        return CUSTOMER_MAPPER.toDto(customerService.updateCustomer(customer));
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteCustomer(@RequestParam @Min(1) Integer id) {
        return customerService.deleteCustomer(id);
    }

}
