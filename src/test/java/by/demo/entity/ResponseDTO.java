package by.demo.entity;

import org.springframework.http.HttpStatus;

import java.util.Objects;

/**
 * Created by alna0916 on 03.04.2017.
 */
public class ResponseDTO {

    private HttpStatus httpStatus;
    private String message;

    public ResponseDTO() {
    }

    public ResponseDTO(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDTO that = (ResponseDTO) o;
        return getHttpStatus() == that.getHttpStatus() &&
                Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHttpStatus(), getMessage());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseDTO{");
        sb.append("httpStatus=").append(httpStatus);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
