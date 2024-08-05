package com.it.support.model;


import com.it.support.enums.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Person{

    public Admin(Long id, String name, String username, String password, Role role) {
        super(id, name, username, password, role);
        this.setRole(Role.ADMIN);
    }


    public Admin() {

    }
}
