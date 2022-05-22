package com.mg.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepoistory extends JpaRepository<Customer, Integer> {
}
