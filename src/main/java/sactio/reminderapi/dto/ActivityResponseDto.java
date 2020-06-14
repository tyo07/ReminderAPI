package sactio.reminderapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import sactio.reminderapi.entity.ActivityEntity;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class ActivityResponseDto {

    private String responseCode;
    private List<ActivityEntity> activityEntityDetails;
    private String message;
}
