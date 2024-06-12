package dev.ashiq.productServicettsevening.clients.authenticationclient.dtos;

import dev.ashiq.productServicettsevening.clients.authenticationclient.dtos.Role;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * DTO for {@link dev.ashiq.userauth2.model.User}
 */
@Getter
@Setter
public class UserDto {
    private String email;
    private Set<Role> roles= new HashSet<>();



}