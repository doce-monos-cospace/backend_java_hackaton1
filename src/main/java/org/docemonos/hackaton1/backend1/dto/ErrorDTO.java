package org.docemonos.hackaton1.backend1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String code;
    private String description;
}
