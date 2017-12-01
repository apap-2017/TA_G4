package com.akademik.mahasiswa.g4.model.rest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseModel<E> {

    private int status;
    private String msg;
    private E result;
}
