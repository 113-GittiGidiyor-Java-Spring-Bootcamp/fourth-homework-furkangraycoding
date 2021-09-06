package dev.patika.fourthhomework.dto;



import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoggerDTO {
    @ApiModelProperty(hidden = true)
    private int id;
    private LocalDate throwDate;
    private String throwMessage;

}
