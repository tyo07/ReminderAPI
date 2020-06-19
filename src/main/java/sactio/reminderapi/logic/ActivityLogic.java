package sactio.reminderapi.logic;

import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityRequestDto;

public interface ActivityLogic {
    ActivityDto findByActivityId(Integer activityId);

    ActivityDto findAllActivities();

    void insertActivities(ActivityRequestDto activityDto);
}
