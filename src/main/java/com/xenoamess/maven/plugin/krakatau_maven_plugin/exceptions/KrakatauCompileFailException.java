package com.xenoamess.maven.plugin.krakatau_maven_plugin.exceptions;

public class KrakatauCompileFailException extends RuntimeException {

    public KrakatauCompileFailException() {
        super();
    }

    public KrakatauCompileFailException(String message) {
        super(message);
    }

    public KrakatauCompileFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public KrakatauCompileFailException(Throwable cause) {
        super(cause);
    }

    protected KrakatauCompileFailException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace
    ) {
        super(
                message,
                cause,
                enableSuppression,
                writableStackTrace
        );
    }

}
