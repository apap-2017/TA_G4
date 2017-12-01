package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseResponseModel<E> {

    @JsonProperty("status")
    private int status;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("result")
    private E result;
}
