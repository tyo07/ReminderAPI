package sactio.reminderapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;
import sactio.reminderapi.logic.ActivityRuntimeLogic;
import sactio.reminderapi.logic.impl.ActivityRuntimeLogicImpl;
import sactio.reminderapi.service.ActivityRuntimeService;

@Service
public class ActivityRuntimeServiceImpl implements ActivityRuntimeService {

    private final ActivityRuntimeLogicImpl activityRuntimeLogicImpl;

    @Autowired
    public ActivityRuntimeServiceImpl(ActivityRuntimeLogicImpl activityRuntimeLogicImpl){
        this.activityRuntimeLogicImpl = activityRuntimeLogicImpl;
    }

    @Override
    public void insertActivityRuntime(ActivityRuntimeRequestDto activityRuntimeRequestDto) {
        activityRuntimeLogicImpl.insertActivityRuntime(activityRuntimeRequestDto);
    }

    @Override
    public ActivityRuntimeDto getAllActivityRuntime() {
        return activityRuntimeLogicImpl.getAllActivityRuntime();
    }

    @Override
    public ActivityRuntimeDto getActivityRuntime(final Integer activityRuntime) {
        return activityRuntimeLogicImpl.findByActivityId(activityRuntime);
    }
}
