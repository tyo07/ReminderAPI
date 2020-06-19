package sactio.reminderapi.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.dto.ActivityRuntimeRequestDto;
import sactio.reminderapi.service.ActivityRuntimeService;

public class ActivityRuntimeControllerTest {
    @Mock
    ActivityRuntimeService activityRuntimeService;
    @InjectMocks
    ActivityRuntimeController activityRuntimeController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInsertActivityRuntime() throws Exception {
        ActivityResponseDto<ActivityRuntimeDto> result = activityRuntimeController.insertActivityRuntime(new ActivityRuntimeRequestDto());
        ActivityResponseDto<ActivityRuntimeDto> expected = new ActivityResponseDto<>();
        expected.setMessage(new ActivityRuntimeRequestDto() + " successfully inserted.");
        expected.setResponseCode(200);
        Assert.assertEquals(expected, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme