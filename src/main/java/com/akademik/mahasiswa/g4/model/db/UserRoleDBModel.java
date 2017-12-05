package com.akademik.mahasiswa.g4.model.db;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDBModel {

    public static final String ROLE_MAHASISWA = "mahasiswa";
    public static final String ROLE_SEKRETARIAT = "seketariat";

    private String username;
    private String role;

    public static String getRoleMahasiswa() {
        return ROLE_MAHASISWA;
    }

    public static String getRoleSekretariat() {
        return ROLE_SEKRETARIAT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
