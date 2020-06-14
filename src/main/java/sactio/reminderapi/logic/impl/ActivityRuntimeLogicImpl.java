package sactio.reminderapi.logic.impl;

import org.springframework.stereotype.Component;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.entity.ActivityRuntimeEntity;
import sactio.reminderapi.logic.ActivityRuntimeLogic;
import sactio.reminderapi.repository.ActivityRuntimeRepository;

@Component

public class ActivityRuntimeLogicImpl implements ActivityRuntimeLogic {

    final ActivityRuntimeRepository activityRuntimeRepository;

    public ActivityRuntimeLogicImpl(final ActivityRuntimeRepository activityRuntimeRepository) {
        this.activityRuntimeRepository = activityRuntimeRepository;
    }

    public void insertActivityRuntime(ActivityRuntimeDto activityRuntimeDto) {
        ActivityRuntimeEntity activityRuntimeEntity = new ActivityRuntimeEntity();
        activityRuntimeEntity.setActivityId(activityRuntimeDto.getActivityId());
        activityRuntimeEntity.setEndTime(activityRuntimeDto.getEndTime());
        activityRuntimeEntity.setStartTime(activityRuntimeDto.getStartTime());
        activityRuntimeRepository.save(activityRuntimeEntity);
    }
}
