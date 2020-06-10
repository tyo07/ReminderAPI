package sactio.reminderapi.logic.impl;

import org.springframework.stereotype.Component;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.entity.ActivityRuntime;
import sactio.reminderapi.logic.ActivityRuntimeLogic;
import sactio.reminderapi.repository.ActivityRuntimeRepository;

@Component

public class ActivityRuntimeLogicImpl implements ActivityRuntimeLogic {

    final ActivityRuntimeRepository activityRuntimeRepository;

    public ActivityRuntimeLogicImpl(final ActivityRuntimeRepository activityRuntimeRepository) {
        this.activityRuntimeRepository = activityRuntimeRepository;
    }

    public void insertActivityRuntime(ActivityRuntimeDto activityRuntimeDto) {
        ActivityRuntime activityRuntime = new ActivityRuntime();
        activityRuntime.setActivityId(activityRuntimeDto.getActivityId());
        activityRuntime.setEndTime(activityRuntimeDto.getEndTime());
        activityRuntime.setStartTime(activityRuntimeDto.getStartTime());
        activityRuntimeRepository.save(activityRuntime);
    }
}
