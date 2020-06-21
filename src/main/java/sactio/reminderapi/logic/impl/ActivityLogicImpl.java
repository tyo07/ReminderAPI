package sactio.reminderapi.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityRequestDto;
import sactio.reminderapi.entity.ActivityEntity;
import sactio.reminderapi.logic.ActivityLogic;
import sactio.reminderapi.repository.ActivityRepository;

import java.util.List;

@Component
public class ActivityLogicImpl implements ActivityLogic {

    private final ActivityRepository activityRepository;

    public ActivityLogicImpl(final ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public ActivityDto findByActivityId(Integer activityId) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityEntityList(activityRepository.findByActivityId(activityId));
        return activityDto;
    }

    public ActivityDto findAllActivities() {
        List<ActivityEntity> activityEntityList = activityRepository.findAll();
        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityEntityList(activityEntityList);
        return activityDto;
    }

    public void insertActivities(ActivityRequestDto activityDto) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivityId(activityDto.getActivityId());
        activityEntity.setActivityName(activityDto.getActivityName());
        activityRepository.save(activityEntity);
    }
}
