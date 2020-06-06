package sactio.reminderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.service.ActivityService;

@RestController
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/api/activity")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto getActivityDetails(@RequestParam(value = "name") String action) {
        ActivityResponseDto activityResponseDto = new ActivityResponseDto();
        activityResponseDto.setResponseCode("200");
        activityResponseDto.setActivityDetails(activityService.createActivityResponse(action));
        return activityResponseDto;
    }
}
