package sactio.reminderapi.logic.impl;

import org.springframework.stereotype.Component;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;
import sactio.reminderapi.entity.ActivityRuntimeEntity;
import sactio.reminderapi.logic.ActivityRuntimeLogic;
import sactio.reminderapi.repository.ActivityRuntimeRepository;

import java.util.List;

@Component

public class ActivityRuntimeLogicImpl implements ActivityRuntimeLogic {

    private final ActivityRuntimeRepository activityRuntimeRepository;

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
        List<ActivityRuntimeEntity> activityRuntimeEntityList = activityRuntimeRepository.findAll();
        ActivityRuntimeDto activityRuntimeDto = new ActivityRuntimeDto();
        activityRuntimeDto.setActivityRuntimeEntityList(activityRuntimeEntityList);
        return activityRuntimeDto;
    }

    @Override
    public ActivityRuntimeDto findByActivityId(final Integer activityRuntime) {
        ActivityRuntimeDto activityRuntimeDto = new ActivityRuntimeDto();
        activityRuntimeDto.setActivityRuntimeEntityList(activityRuntimeRepository.findByActivityId(activityRuntime));
        return activityRuntimeDto;
    }


}
