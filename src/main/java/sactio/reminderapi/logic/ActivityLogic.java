package sactio.reminderapi.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sactio.reminderapi.entity.Activity;
import sactio.reminderapi.repository.ActivityRepository;

import java.util.List;
@Component

public class ActivityLogic {

    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getListActivityId(String activityId) {
        return activityRepository.findByActivityId(activityId);
    }
}
