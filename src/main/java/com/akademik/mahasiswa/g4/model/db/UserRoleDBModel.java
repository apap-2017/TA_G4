package com.akademik.mahasiswa.g4.model.db;

public class UserRoleDBModel {

    public static final String ROLE_MAHASISWA = "mahasiswa";
    public static final String ROLE_SEKRETARIAT = "seketariat";

    private String username;
    private String role;

    public UserRoleDBModel(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public UserRoleDBModel() {
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
