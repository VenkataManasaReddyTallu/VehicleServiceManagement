package com.primeauto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.primeauto.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
