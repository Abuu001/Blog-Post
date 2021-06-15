package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape=JsonFormat.Shape.STRING)
public enum UserRoles {
    ADMIN("ADMIN"),
    USER("USER"),
    GUEST("GUEST");

    private final String role;

    UserRoles(String role) {
        this.role = role;
    }


}
