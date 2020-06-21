package sactio.reminderapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityRequestDto;
import sactio.reminderapi.logic.ActivityLogic;
import sactio.reminderapi.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {


    private final ActivityLogic activityLogic;


    public ActivityServiceImpl(ActivityLogic activityLogic) {
        this.activityLogic = activityLogic;
    }

    public ActivityDto getActivityById(Integer activityId) {
        return activityLogic.findByActivityId(activityId);
    }

    public ActivityDto getAllActivities() {
        return activityLogic.findAllActivities();
    }

    public void insertActivity(ActivityRequestDto activityDto) {
        activityLogic.insertActivities(activityDto);
    }

}
