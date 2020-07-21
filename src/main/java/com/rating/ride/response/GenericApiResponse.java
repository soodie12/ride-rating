package com.rating.ride.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GenericApiResponse<T> implements Serializable {

    public T data;
    private String message;
    private boolean success;


    public GenericApiResponse(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }
}