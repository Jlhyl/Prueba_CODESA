package com.codesa.dao;

import com.codesa.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

    public List<Usuario> findByNombreContaining(String name);

}
