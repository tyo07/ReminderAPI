package sactio.reminderapi.logic;

import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.Activity;

import java.util.List;

public interface ActivityLogic {
    List<Activity> getListActivityId(String activityId);

    List<Activity> findAllActivities();

    void insertActivities(ActivityDto activityDto);
}
