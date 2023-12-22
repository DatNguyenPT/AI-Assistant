package com.Datnguyen.AI.Assistant.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
@Entity
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "username")
    private String username;
    @NotEmpty(message = "Login Name Can Not Be Blank")
    @Column(name = "loginname")
    private String loginname;
    @NotEmpty(message = "Password Can Not Be Blank")
    @Column(name = "password")
    private String password;

    @NotNull(message = "No Existed Account")
    public UserEntity(String username, String loginname, String password) {
        this.username = username;
        this.loginname = loginname;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
