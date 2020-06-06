package sactio.reminderapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import sactio.reminderapi.entity.ActivityName;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class ActivityResponseDto {

    private String responseCode;
    private List<ActivityName> activityDetails;
}
