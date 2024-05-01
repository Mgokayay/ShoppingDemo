package com.invio.shopping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role", schema = "shopping ")
public class Role implements GrantedAuthority{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority")
    private String authority;


    @Override
    public String getAuthority() {
        return authority;
    }


}
