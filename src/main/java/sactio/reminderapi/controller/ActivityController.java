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
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityRequestDto;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.service.impl.ActivityServiceImpl;

@RestController
@RequestMapping(value = "/api/activity")
public class ActivityController {

    private final ActivityServiceImpl activityServiceImpl;

    @Autowired
    public ActivityController(final ActivityServiceImpl activityServiceImpl) {
        this.activityServiceImpl = activityServiceImpl;
    }

    @GetMapping("/get/{activityId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityDto> getActivity(@PathVariable Integer activityId) {
        ActivityResponseDto<ActivityDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage("Success");
        activityResponseDto.setData(activityServiceImpl.getActivityById(activityId));
        return activityResponseDto;
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityDto> getAllActivity() {
        ActivityResponseDto<ActivityDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage("Success");
        activityResponseDto.setData(activityServiceImpl.getAllActivities());
        return activityResponseDto;
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ActivityResponseDto<ActivityRequestDto> insertActivity(@RequestBody ActivityRequestDto activityRequestDto) {
        activityServiceImpl.insertActivity(activityRequestDto);
        ActivityResponseDto<ActivityRequestDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(201);
        activityResponseDto.setMessage("Success");
        activityResponseDto.setData(activityRequestDto);
        return activityResponseDto;
    }


}
