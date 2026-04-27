package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.entity.Usuario;
import br.com.studio.beautymanager.repository.UsuarioRepository;

import br.com.studio.beautymanager.entity.Studio;
import br.com.studio.beautymanager.repository.StudioRepository;

import br.com.studio.beautymanager.service.JwtService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final StudioRepository studioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;

    public AuthController(UsuarioRepository usuarioRepository,
                          StudioRepository studioRepository,
                          JwtService jwtService,
                          PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.studioRepository = studioRepository;
        this.jwtService = jwtService;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario login){

        if (login.getEmail() == null || login.getEmail().isBlank() ||
            login.getSenha() == null || login.getSenha().isBlank()) {

            return ResponseEntity.badRequest().body("Email e senha são obrigatórios");
        }

        Usuario usuario = usuarioRepository.findByEmail(login.getEmail());

        if (usuario == null || !encoder.matches(login.getSenha(), usuario.getSenha())) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }

        Studio empresa = studioRepository.findByStudioId(usuario.getStudioId());

        String token = jwtService.gerarToken(usuario.getStudioId());

        Map<String,String> resposta = new HashMap<>();
        resposta.put("token", token);
        resposta.put("nome", usuario.getNome());
        resposta.put("empresa", empresa.getNome()+" - "+empresa.getCidade());

        return ResponseEntity.ok(resposta);
    }
}