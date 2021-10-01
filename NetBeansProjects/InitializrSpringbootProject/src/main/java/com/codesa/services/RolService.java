package com.codesa.services;

import com.codesa.dao.RolDAO;
import com.codesa.models.Rol;
import com.codesa.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Rol")
public class RolService {

    //Dependency Injection
    @Autowired
    private RolDAO rolDao;

    @GetMapping("/list")
    public List<Rol> list(){
        return rolDao.findAll();
    }
}
