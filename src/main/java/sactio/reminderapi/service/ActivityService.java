package sactio.reminderapi.service;

import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.ActivityEntity;

import java.util.List;

public interface ActivityService {

    public List<ActivityEntity> getListActivityId(String activityId);

    public List<ActivityEntity> getAllActivities();

    public void insertActivity(ActivityDto activityDto);

}
