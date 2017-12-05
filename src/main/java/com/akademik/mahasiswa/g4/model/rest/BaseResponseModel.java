package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BaseResponseModel<E> {

    @JsonProperty("status")
    private int status;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("result")
    private E result;

    public BaseResponseModel(int status, String msg, E result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public E getResult() {
        return result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(E result) {
        this.result = result;
    }
}
