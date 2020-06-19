package sactio.reminderapi.logic.impl;

import org.springframework.stereotype.Component;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;
import sactio.reminderapi.entity.ActivityRuntimeEntity;
import sactio.reminderapi.logic.ActivityRuntimeLogic;
import sactio.reminderapi.repository.ActivityRuntimeRepository;

@Component

public class ActivityRuntimeLogicImpl implements ActivityRuntimeLogic {

    final ActivityRuntimeRepository activityRuntimeRepository;

    public ActivityRuntimeLogicImpl(final ActivityRuntimeRepository activityRuntimeRepository) {
        this.activityRuntimeRepository = activityRuntimeRepository;
    }

    public void insertActivityRuntime(ActivityRuntimeRequestDto activityRuntimeRequestDto) {
        ActivityRuntimeEntity activityRuntimeEntity = new ActivityRuntimeEntity();
        activityRuntimeEntity.setActivityId(activityRuntimeRequestDto.getActivityId());
        activityRuntimeEntity.setEndTime(activityRuntimeRequestDto.getEndTime());
        activityRuntimeEntity.setStartTime(activityRuntimeRequestDto.getStartTime());
        activityRuntimeRepository.save(activityRuntimeEntity);
    }

    @Override
    public ActivityRuntimeDto getAllActivityRuntime() {
        return null;
    }

    @Override
    public ActivityRuntimeDto getActivityRuntime(final String activityRuntime) {
        return null;
    }


}
