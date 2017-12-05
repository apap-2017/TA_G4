package com.akademik.mahasiswa.g4.model.db;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDBModel {
    private String username;
    private String password;
}
