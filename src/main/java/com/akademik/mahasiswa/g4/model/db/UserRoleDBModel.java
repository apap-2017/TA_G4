package com.akademik.mahasiswa.g4.model.db;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRoleDBModel {

    public static final String ROLE_MAHASISWA = "mahasiswa";
    public static final String ROLE_SEKRETARIAT = "seketariat";

    private String username;
    private String role;

}
