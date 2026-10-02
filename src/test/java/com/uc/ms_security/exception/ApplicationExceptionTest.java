package com.uc.ms_security.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationExceptionTest {

    @Test
    void shouldKeepErrorCaseAndMessage() {
        ApplicationException exception = new ApplicationException(
                ErrorCase.NOT_FOUND,
                "Usuario no encontrado");

        assertEquals(ErrorCase.NOT_FOUND, exception.getErrorCase());
        assertEquals("Usuario no encontrado", exception.getMessage());
    }
}
