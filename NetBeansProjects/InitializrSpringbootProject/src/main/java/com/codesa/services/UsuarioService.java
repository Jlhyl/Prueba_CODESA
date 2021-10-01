package com.codesa.services;

import com.codesa.dao.UsuarioDAO;
import com.codesa.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Usuario") 
public class UsuarioService {

    //Dependency Injection
    @Autowired
    private UsuarioDAO usuarioDAO;


    //HTTP Methods    
    @GetMapping("/list")
    public List<Usuario> list(){
        return usuarioDAO.findAll();
    }

    @GetMapping("/list/{name}")  
    public List<Usuario> listUserByName(@PathVariable("name") String name){
        return usuarioDAO.findByNombreContaining(name);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUser(@PathVariable("id") Integer id){
        return usuarioDAO.findById(id);
    }

    @PostMapping("/save")
    public Usuario save(@RequestBody Usuario user){
        usuarioDAO.save(user);
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        usuarioDAO.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Usuario user){
        usuarioDAO.save(user);
    }

}
