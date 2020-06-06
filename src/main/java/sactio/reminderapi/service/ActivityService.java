package sactio.reminderapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sactio.reminderapi.entity.ActivityName;
import sactio.reminderapi.logic.ActivityLogic;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityLogic activityLogic;

    public List<ActivityName> createActivityResponse(String activityId){
        return activityLogic.getListActivityId(activityId);
    }
}
