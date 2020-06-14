package sactio.reminderapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import sactio.reminderapi.entity.ActivityRuntimeEntity;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class ActivityRuntimeDto {
    private List<ActivityRuntimeEntity> activityRuntimeEntityList;
}
