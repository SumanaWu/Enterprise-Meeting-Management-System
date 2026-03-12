package org.example.identity.service;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

/**
 * wrapper for parameters of user
 */
@Getter
@Setter
public class IdentityParameters {
    String name;

    String email;

    String phone;

    String address;

    int age;

    String nation;

    String passwd;
}
