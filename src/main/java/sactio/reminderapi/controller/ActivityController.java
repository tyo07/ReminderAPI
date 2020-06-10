package sactio.reminderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.entity.Activity;
import sactio.reminderapi.service.ActivityService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/api/activity/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto getActivityDetails(@PathVariable String name) {
        ActivityResponseDto activityResponseDto = new ActivityResponseDto();
        activityResponseDto.setResponseCode("200");
        activityResponseDto.setActivityDetails(activityService.createActivityResponse(name));
        return activityResponseDto;
    }

    @GetMapping("/api/activity")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto getAllActivity() {
        ActivityResponseDto activityResponseDto = new ActivityResponseDto();
        activityResponseDto.setResponseCode("200");
        Activity activity = new Activity();
        activity.setActivityId("123");
        activity.setActivityName("TEST");
        List<Activity> activityList = new ArrayList<>();
        activityList.add(activity);
        activityResponseDto.setActivityDetails(activityList);
        return activityResponseDto;
    }
}
