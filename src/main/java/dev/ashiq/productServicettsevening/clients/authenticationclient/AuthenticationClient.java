package dev.ashiq.productServicettsevening.clients.authenticationclient;

import dev.ashiq.productServicettsevening.clients.authenticationclient.dtos.ValidateTokenRequestDto;
import dev.ashiq.productServicettsevening.clients.authenticationclient.dtos.ValidateTokenResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationClient {
    private RestTemplateBuilder restTemplateBuilder;

    public AuthenticationClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ValidateTokenResponseDto validate(String token, Long userId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ValidateTokenRequestDto request = new ValidateTokenRequestDto();
        request.setToken(token);
        request.setUserId(userId);

        ResponseEntity<ValidateTokenResponseDto> l = restTemplate.postForEntity(
                "http://localhost:8082/auth/validate",
                request,
                ValidateTokenResponseDto.class
        );

        return l.getBody();
    }
}
