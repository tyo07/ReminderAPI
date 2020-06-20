package sactio.reminderapi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class ActivityResponseDto<ResponseDto> {

    private Integer responseCode;
    private String message;
    private ResponseDto data;
}
