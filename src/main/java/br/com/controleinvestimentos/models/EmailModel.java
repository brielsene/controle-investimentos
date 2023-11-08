package br.com.controleinvestimentos.models;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel {
    @Email
    private String emailTo;

    private String subject;

    private String messageBody;


}
