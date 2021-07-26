package org.examen.exception;

/**
 *
 * @author Eduardo
 */
public enum ServerErrors {
    MASCOTA_NOT_FOUND("No se encontró la mascota"),
    PROPIETARIO_NOT_FOUND("No se encontró el propietario"),
    RAZA_MASCOTA_NOT_FOUND("No se encontró la raza de mascota "),
    TIPO_MASCOTA_NOT_FOUND("No se encontró el tipo de mascota"),
    TIPO_VACUNA_NOT_FOUND("No se encontró el "),
    VACUNA_NOT_FOUND("No se encontró la vacuna "),
    VETERINARIO_NOT_FOUND("No se encontró el veterinario"),
    ;

    private final String message;

    ServerErrors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
