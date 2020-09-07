package com.kappakorp.hikaricp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/welcome")
public class WelcomeController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("")
    public ResponseEntity<Object> method1() {

        Map<String, String> map = new HashMap<>();
        //List<Users> users = usersRepository.findAll();
        //map.put("id", users.getId().toString());
        //map.put("name", users.size()+"");
        map.put("Tenant", (String) TenantContextHolder.getTenantType());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/bye")
    public ResponseEntity<Object> method2() {

        Map<String, String> map = new HashMap<>();
        map.put("Tenant", (String) TenantContextHolder.getTenantType());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}

