package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

          public List<Tenant> listAll(){
              return tenantRepository.findAll();
          }


           public Tenant getTenantOnById(Integer id){
            return tenantRepository.findById(id).get();

           }

      public void saveTenant(Tenant tenant){
          tenantRepository.save(tenant);
    }

    public void deleteTenant(Integer id){
          tenantRepository.deleteById(id);
    }


}
