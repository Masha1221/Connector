package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

public class TenantController {

    @Controller
    @RequestMapping(path="/demo")
    public class MainController {
        @Autowired
        private TenantService tenantService;

        @GetMapping("/tenants")
        public List<Tenant> list(){
            return tenantService.listAll();
        }

        @GetMapping("/tenants/{id}")
        public ResponseEntity<Tenant> get(@PathVariable Integer id) {
            try {
                Tenant tenant = tenantService.getTenantOnById(id);
                return new ResponseEntity<Tenant>(tenant, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<Tenant>(HttpStatus.NOT_FOUND);
            }
        }
            @PostMapping("/tenants")
            public String create(@RequestBody Tenant tenant) {
                tenantService.saveTenant(tenant);
                return "create new Tenant/";
            }

        @PutMapping("/products/{id}")
        public ResponseEntity<?> update(@RequestBody Tenant product, @PathVariable Integer id) {
            try {
                Tenant existTenant = tenantService.getTenantOnById(id);
                tenantService.saveTenant(product);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @DeleteMapping("/tenant/{id}")
        public String delete(@PathVariable Integer id) {
            tenantService.deleteTenant(id);
            return "redirect:";
        }

    }

}

