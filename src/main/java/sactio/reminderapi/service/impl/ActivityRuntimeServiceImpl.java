package sactio.reminderapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.logic.ActivityRuntimeLogic;
import sactio.reminderapi.service.ActivityRuntimeService;

@Service
public class ActivityRuntimeServiceImpl implements ActivityRuntimeService {

    final ActivityRuntimeLogic activityRuntimeLogic;

    @Autowired
    public ActivityRuntimeServiceImpl(ActivityRuntimeLogic activityRuntimeLogic){
        this.activityRuntimeLogic = activityRuntimeLogic;
    }
    public void insertActivityRuntime(ActivityRuntimeDto activityRuntimeDto) {
        activityRuntimeLogic.insertActivityRuntime(activityRuntimeDto);
    }
}
