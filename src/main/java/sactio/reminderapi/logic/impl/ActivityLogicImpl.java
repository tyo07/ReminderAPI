package sactio.reminderapi.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.Activity;
import sactio.reminderapi.logic.ActivityLogic;
import sactio.reminderapi.repository.ActivityRepository;

import java.util.List;

@Component

public class ActivityLogicImpl implements ActivityLogic {

    final ActivityRepository activityRepository;

    public ActivityLogicImpl(final ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getListActivityId(String activityId) {
        return activityRepository.findByActivityId(activityId);
    }

    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    public void insertActivities(ActivityDto activityDto) {
        Activity activity = new Activity();
        activity.setActivityId(activityDto.getActivityId());
        activity.setActivityName(activityDto.getActivityName());
        activityRepository.save(activity);
    }
}
