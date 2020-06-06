package sactio.reminderapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sactio.reminderapi.dto.ResponseReminder;

@RestController
public class ReminderController {

    @GetMapping("/api/reminder")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseReminder getReminder(@RequestParam(value = "action") String action) {
        ResponseReminder responseReminder = new ResponseReminder();
        responseReminder.setResponseCode("200");
        responseReminder.setMessage("Hello: "+action);
        return responseReminder;
    }
}
