package com.akademik.mahasiswa.g4.model;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IRSFormModel {
    private Map<String, Integer> selectedKelas;
}
