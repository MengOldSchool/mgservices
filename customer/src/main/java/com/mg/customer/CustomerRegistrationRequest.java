package com.mg.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomerRegistrationRequest {
        private String firstName;
        private String lastName;
        private String email;
}
