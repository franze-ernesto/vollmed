package br.com.casa.voll.med.interfaces.web.controller;

import br.com.casa.voll.med.interfaces.web.dto.input.UsuarioInputDTO;
import br.com.casa.voll.med.infrastructure.security.DadosTokenJWT;
import br.com.casa.voll.med.infrastructure.security.TokenService;
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
@RequestMapping("/auth/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid UsuarioInputDTO usuarioInputDTO) {
        var token = new UsernamePasswordAuthenticationToken(
                usuarioInputDTO.getLogin(),
                usuarioInputDTO.getSenha()
        );

        var autenticacao = manager.authenticate(token);
        var jwt = tokenService.gerarToken(autenticacao);

        System.out.println("🔐 Token gerado: " + jwt);
        return ResponseEntity.ok(new DadosTokenJWT(jwt));

    }
}
