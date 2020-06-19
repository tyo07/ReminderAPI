package sactio.reminderapi.service;

import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityRequestDto;

public interface ActivityService {

    public ActivityDto getActivityById(Integer activityId);

    public ActivityDto getAllActivities();

    public void insertActivity(ActivityRequestDto activityDto);

}
