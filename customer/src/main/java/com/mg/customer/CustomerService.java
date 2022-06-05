package com.mg.customer;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService  {

    private final CustomerRepoistory customerRepoistory;
    private final RestTemplate restTemplate;

    public CustomerService(CustomerRepoistory customerRepoistory, RestTemplate restTemplate) {
        this.customerRepoistory = customerRepoistory;
        this.restTemplate = restTemplate;
    }

    public void regsiterCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .build();

        customerRepoistory.saveAndFlush(customer);

        System.out.println("start to send the message!!!");

        //todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        System.out.println("send the message!!!");

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        //todo: send notificaton
    }
}
