package com.example.api_application.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthEvent {

    @EventListener
    public void autenticaSucesso(AuthenticationSuccessEvent acesso){
        log.info("Autenticado com Sucesso: {}", acesso.getAuthentication().getName());
    }

    @EventListener
    public void autenticaFalha(AbstractAuthenticationEvent falha){
        log.info("Autenticado com Falha: {}", falha.getAuthentication().getName());
    }

}
