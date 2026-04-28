package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.entity.Produto;
import br.com.studio.beautymanager.service.JwtService;
import br.com.studio.beautymanager.service.ProdutoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;
    private final JwtService jwtService;

    public ProdutoController(ProdutoService service, JwtService jwtService) {
        this.service = service;
        this.jwtService = jwtService;
    }

    private Long getStudioId(String authHeader) {
        return jwtService.getStudioId(authHeader);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestHeader("Authorization") String token,
                                   @RequestBody Produto produto) {

        Long studioId = getStudioId(token);
        return ResponseEntity.ok(service.salvar(produto, studioId));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar(@RequestHeader("Authorization") String token) {

        Long studioId = getStudioId(token);
        return ResponseEntity.ok(service.listar(studioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id,
                                      @RequestBody Produto produto) {

        return ResponseEntity.ok(service.atualizar(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {

        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}