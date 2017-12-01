package com.akademik.mahasiswa.g4.model.db;

public class UserDBModel {
    private String username;
    private String password;

    public UserDBModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDBModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
