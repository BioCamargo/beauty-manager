package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.entity.Usuario;
import br.com.studio.beautymanager.service.UsuarioService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private PasswordEncoder encoder; // O Spring injeta o BCrypt aqui    
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return service.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar(null);
    }
}