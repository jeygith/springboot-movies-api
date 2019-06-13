package com.githinit.springboot.moviesapi.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException() {
        super();
    }

    public MovieNotFoundException(String s) {
        super(s);
    }

    public MovieNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public MovieNotFoundException(Throwable throwable) {
        super(throwable);
    }

    protected MovieNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
