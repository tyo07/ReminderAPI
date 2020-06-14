package sactio.reminderapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.Activity;
import sactio.reminderapi.logic.ActivityLogic;

import java.util.List;

@Service
public class ActivityServiceImpl {


    final ActivityLogic activityLogic;

    @Autowired
    public ActivityServiceImpl(ActivityLogic activityLogic) {
        this.activityLogic = activityLogic;
    }

    public List<Activity> getListActivityId(String activityId) {
        return activityLogic.getListActivityId(activityId);
    }

    public List<Activity> getAllActivities() {
        return activityLogic.findAllActivities();
    }

    public void insertActivity(ActivityDto activityDto) {
        activityLogic.insertActivities(activityDto);
    }

}
