package com.example.easynotes.exception;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundException() {
        // Definir valores de prueba
        String resourceName = "ExampleResource";
        String fieldName = "exampleField";
        Object fieldValue = "exampleValue";

        // Crear la excepción
        ResourceNotFoundException exception = new ResourceNotFoundException(resourceName, fieldName, fieldValue);

        // Verificar que el mensaje de la excepción sea el esperado
        String expectedMessage = String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue);
        assertEquals(expectedMessage, exception.getMessage());

        // Verificar que los getters devuelvan los valores correctos
        assertEquals(resourceName, exception.getResourceName());
        assertEquals(fieldName, exception.getFieldName());
        assertEquals(fieldValue, exception.getFieldValue());
    }
}
