package sactio.reminderapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class ActivityRuntimeRequestDto {

    private Integer activityId;
    private String startTime;
    private String endTime;
}
