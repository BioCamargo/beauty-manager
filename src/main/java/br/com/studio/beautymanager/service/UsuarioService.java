package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.entity.Usuario;
import br.com.studio.beautymanager.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listar(Object object) {
        return repository.findAll();
    }
}