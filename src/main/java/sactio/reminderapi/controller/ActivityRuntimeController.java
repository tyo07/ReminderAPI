package sactio.reminderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.service.ActivityRuntimeService;

@RestController
public class ActivityRuntimeController {

    final ActivityRuntimeService activityRuntimeService;

    @Autowired
    public ActivityRuntimeController(final ActivityRuntimeService activityRuntimeService) {
        this.activityRuntimeService = activityRuntimeService;
    }


    @PostMapping("/api/activityruntime/insert")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto insertActivityRuntime(@RequestBody ActivityRuntimeDto activityRuntimeDto) {
        activityRuntimeService.insertActivityRuntime(activityRuntimeDto);
        ActivityResponseDto activityResponseDto = new ActivityResponseDto();
        activityResponseDto.setResponseCode("200");
        activityResponseDto.setMessage(activityRuntimeDto + " successfully inserted.");
        return activityResponseDto;
    }

}
