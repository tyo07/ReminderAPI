package sactio.reminderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sactio.reminderapi.constant.ActivityConstants;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;
import sactio.reminderapi.service.ActivityRuntimeService;

@RestController
@RequestMapping(value="/api/activityruntime")
public class ActivityRuntimeController {

    private final ActivityRuntimeService activityRuntimeService;

    public ActivityRuntimeController(final ActivityRuntimeService activityRuntimeService) {
        this.activityRuntimeService = activityRuntimeService;
    }


    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ActivityResponseDto<ActivityRuntimeRequestDto> insertActivityRuntime(@RequestBody ActivityRuntimeRequestDto activityRuntimeRequestDto) {
        activityRuntimeService.insertActivityRuntime(activityRuntimeRequestDto);
        ActivityResponseDto<ActivityRuntimeRequestDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(201);
        activityResponseDto.setMessage(ActivityConstants.SUCCESS);
        activityResponseDto.setData(activityRuntimeRequestDto);
        return activityResponseDto;
    }

    @GetMapping("/get/{activityId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityRuntimeDto> getActivityRuntime(@PathVariable Integer activityId) {
        ActivityResponseDto<ActivityRuntimeDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage(ActivityConstants.SUCCESS);
        activityResponseDto.setData(activityRuntimeService.getActivityRuntime(activityId));
        return activityResponseDto;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityRuntimeDto> getAllActivityRuntime() {
        ActivityResponseDto<ActivityRuntimeDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage(ActivityConstants.SUCCESS);
        activityResponseDto.setData(activityRuntimeService.getAllActivityRuntime());
        return activityResponseDto;
    }

}
