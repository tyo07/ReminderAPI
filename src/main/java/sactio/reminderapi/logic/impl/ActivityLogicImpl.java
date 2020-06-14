package sactio.reminderapi.logic.impl;

import org.springframework.stereotype.Component;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.ActivityEntity;
import sactio.reminderapi.logic.ActivityLogic;
import sactio.reminderapi.repository.ActivityRepository;

import java.util.List;

@Component

public class ActivityLogicImpl implements ActivityLogic {

    final ActivityRepository activityRepository;

    public ActivityLogicImpl(final ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityEntity> getListActivityId(String activityId) {
        return activityRepository.findByActivityId(activityId);
    }

    public List<ActivityEntity> findAllActivities() {
        return activityRepository.findAll();
    }

    public void insertActivities(ActivityDto activityDto) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivityId(activityDto.getActivityId());
        activityEntity.setActivityName(activityDto.getActivityName());
        activityRepository.save(activityEntity);
    }
}
