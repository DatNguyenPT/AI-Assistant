package com.Datnguyen.AI.Assistant.Entity;

import com.Datnguyen.AI.Assistant.Security.ValidEmailAnnotation;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Column(name = "username")
    private String username;

    @Id
    @NotEmpty(message = "Email Can Not Be Blank")
    @Column(name = "email")
    @ValidEmailAnnotation
    private String email;
    @NotEmpty(message = "Password Can Not Be Blank")
    @Column(name = "password")
    private String password;

    @NotNull(message = "No Existed Account")
    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setLoginname(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
