package com.minhtrung.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter @Getter @ToString
public class Account extends AbstractModel {
    private String username;
    private String password;
    private String fullname;
    private int status;
    private Long roleid;
    private String email;
    private Role role = new Role();

}
