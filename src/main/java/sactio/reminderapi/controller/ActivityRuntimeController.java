package sactio.reminderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;
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
    public ActivityResponseDto<ActivityRuntimeDto> insertActivityRuntime(@RequestBody ActivityRuntimeRequestDto activityRuntimeRequestDto) {
        activityRuntimeService.insertActivityRuntime(activityRuntimeRequestDto);
        ActivityResponseDto<ActivityRuntimeDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage(activityRuntimeRequestDto + " successfully inserted.");
        activityResponseDto.setData(null);
        return activityResponseDto;
    }

    @GetMapping("/api/activityruntime/get/{activityruntime}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityRuntimeDto> getActivityRuntime(@RequestBody String activityRuntime) {
        ActivityResponseDto<ActivityRuntimeDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage("Success");
        activityResponseDto.setData(activityRuntimeService.getActivityRuntime(activityRuntime));
        return activityResponseDto;
    }

    @GetMapping("/api/activityruntime/get}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityRuntimeDto> getAllActivityRuntime() {
        ActivityResponseDto<ActivityRuntimeDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage("Success");
        activityResponseDto.setData(activityRuntimeService.getAllActivityRuntime());
        return activityResponseDto;
    }

}
