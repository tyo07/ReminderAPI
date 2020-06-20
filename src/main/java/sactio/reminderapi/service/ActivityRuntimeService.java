package sactio.reminderapi.service;

import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;

public interface ActivityRuntimeService {

    void insertActivityRuntime(ActivityRuntimeRequestDto activityRuntimeRequestDto);

    ActivityRuntimeDto getActivityRuntime(Integer activityRuntime);

    ActivityRuntimeDto getAllActivityRuntime();
}
