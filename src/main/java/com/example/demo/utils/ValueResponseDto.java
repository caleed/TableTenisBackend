package com.example.demo.utils;

public class ValueResponseDto<T> {

    private T value;

    public ValueResponseDto(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
