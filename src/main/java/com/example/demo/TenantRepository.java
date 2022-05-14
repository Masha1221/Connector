package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {

    List<Tenant> findTenantById(Integer id);
}
