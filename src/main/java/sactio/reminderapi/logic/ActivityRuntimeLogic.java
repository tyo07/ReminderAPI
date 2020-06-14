package sactio.reminderapi.logic;

import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;

public interface ActivityRuntimeLogic {
     void insertActivityRuntime(ActivityRuntimeRequestDto activityRuntimeRequestDto);
     ActivityRuntimeDto getAllActivityRuntime();
     ActivityRuntimeDto getActivityRuntime(String activityRuntime);
}
