package br.com.casa.voll.med.controller;

import br.com.casa.voll.med.dto.UsuarioRequestDTO;
import br.com.casa.voll.med.security.DadosTokenJWT;
import br.com.casa.voll.med.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {
        var token = new UsernamePasswordAuthenticationToken(
                usuarioRequestDTO.getLogin(),
                usuarioRequestDTO.getSenha()
        );

        var autenticacao = manager.authenticate(token);
        var jwt = tokenService.gerarToken(autenticacao);

        return ResponseEntity.ok(new DadosTokenJWT(jwt));

    }
}
