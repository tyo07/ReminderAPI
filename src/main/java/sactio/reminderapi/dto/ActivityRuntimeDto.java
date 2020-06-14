package sactio.reminderapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class ActivityRuntimeDto {
    private String activityId;
    private String startTime;
    private String endTime;
}
