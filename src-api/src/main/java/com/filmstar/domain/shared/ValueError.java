package com.filmstar.domain.shared;

public class ValueError extends Exception{
    public ValueError(String message) {
        super(message);
    }
}