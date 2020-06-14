package sactio.reminderapi.logic;

import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.ActivityEntity;

import java.util.List;

public interface ActivityLogic {
    List<ActivityEntity> getListActivityId(String activityId);

    List<ActivityEntity> findAllActivities();

    void insertActivities(ActivityDto activityDto);
}
