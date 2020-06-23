package sactio.reminderapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;
import sactio.reminderapi.logic.ActivityRuntimeLogic;
import sactio.reminderapi.service.ActivityRuntimeService;

@Service
class ActivityRuntimeServiceImpl implements ActivityRuntimeService {

    private final ActivityRuntimeLogic activityRuntimeLogic;

    public ActivityRuntimeServiceImpl(ActivityRuntimeLogic activityRuntimeLogic){
        this.activityRuntimeLogic = activityRuntimeLogic;
    }

    @Override
    public void insertActivityRuntime(ActivityRuntimeRequestDto activityRuntimeRequestDto) {
        activityRuntimeLogic.insertActivityRuntime(activityRuntimeRequestDto);
    }

    @Override
    public ActivityRuntimeDto getAllActivityRuntime() {
        return activityRuntimeLogic.getAllActivityRuntime();
    }

    @Override
    public ActivityRuntimeDto getActivityRuntime(final Integer activityRuntime) {
        return activityRuntimeLogic.findByActivityId(activityRuntime);
    }
}
