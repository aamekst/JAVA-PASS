package com.user.password;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private String nome;
    private String password;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}