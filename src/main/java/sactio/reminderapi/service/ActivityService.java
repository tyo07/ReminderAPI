package sactio.reminderapi.service;

import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.Activity;

import java.util.List;

public interface ActivityService {

    public List<Activity> getListActivityId(String activityId);

    public List<Activity> getAllActivities();

    public void insertActivity(ActivityDto activityDto);

}
