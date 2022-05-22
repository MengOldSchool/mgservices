package com.mg.customer;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class CustomerService  {

    private CustomerRepoistory customerRepoistory;

    public CustomerService(CustomerRepoistory customerRepoistory) {
        this.customerRepoistory = customerRepoistory;
    }

    public void regsiterCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .build();

        customerRepoistory.save(customer);
        }
}
