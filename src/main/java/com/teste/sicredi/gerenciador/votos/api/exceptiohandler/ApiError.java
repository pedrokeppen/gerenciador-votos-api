package com.teste.sicredi.gerenciador.votos.api.exceptiohandler;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError implements Serializable {

    private static final long serialVersionUID = 6430733760654466807L;

    @JsonProperty("message")
    private String message;

    @JsonInclude(Include.NON_NULL)
    private List<String> errors;

    public ApiError(String message) {
        this.message = message;
    }
}
