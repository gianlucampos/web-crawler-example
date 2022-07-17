package br.com.gianlucampos.webcrawler.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginCredentials {

    private String login;
    private String password;

}
