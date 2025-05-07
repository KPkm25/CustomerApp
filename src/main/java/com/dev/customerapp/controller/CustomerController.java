package com.dev.customerapp.controller;

import com.dev.customerapp.entity.Customer;
import com.dev.customerapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") long id, @Valid @RequestBody Customer customer) {
        if (!customerRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid customer Id:" + id);
        }
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") long id) {
        customerRepository.deleteById(id);
    }
}
