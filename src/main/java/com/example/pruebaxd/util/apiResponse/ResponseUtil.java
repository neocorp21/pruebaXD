package com.example.pruebaxd.util.apiResponse;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.example.pruebaxd.util.manejoErrores.validation.ValidationException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUtil {

    private Object data;
    private String message;

    private String status;
    private String detalleError;

    // Constructor por defecto
    public ResponseUtil() {
    }

    // LISTADO
    public ResponseUtil(Object data) {
        this.data = data;
    }

    // RESPUESTA CON STATUS REGISTRO O MODIFACION
    public ResponseUtil(Object data, String status) {
        this.data = data;
        this.status = status;
    }
  //para ERROR
    public ResponseUtil(String message, String status, String detalleError) {
        this.message = message;
        this.status = status;
        this.detalleError = detalleError;
    }

    // Respuesta OK
    public <T> ResponseEntity<?> getResponseEntityOk(Object request) {
        ResponseUtil response = new ResponseUtil(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Respuesta de error
    public <T> ResponseEntity<?> getResponseEntityError(ValidationException ex) {
        ResponseUtil errorResponse = new ResponseUtil();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setDetalleError(ex.getMessage()); // asumiendo que ex.getErrors() devuelve detalles del error
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }


    public ResponseEntity<?> getExceptionGlobal(String status, String errorMessage, String details) {
        ResponseUtil errorResponse = new ResponseUtil();
        errorResponse.setMessage(errorMessage);
        errorResponse.setStatus(status);
        errorResponse.setDetalleError(details); // asumiendo que ex.getErrors() devuelve detalles del error
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
