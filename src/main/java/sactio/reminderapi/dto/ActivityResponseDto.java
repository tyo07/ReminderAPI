package sactio.reminderapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import sactio.reminderapi.entity.Activity;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class ActivityResponseDto {

    private String responseCode;
    private List<Activity> activityDetails;
    private String message;
}
