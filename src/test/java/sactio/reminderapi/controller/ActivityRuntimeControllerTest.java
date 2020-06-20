package sactio.reminderapi.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.constant.ActivityConstants;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.service.impl.ActivityRuntimeServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class ActivityRuntimeControllerTest {
    @Mock
    ActivityRuntimeServiceImpl activityRuntimeServiceImpl;
    @InjectMocks
    ActivityRuntimeController activityRuntimeController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetActivityRunTime() {
        when(activityRuntimeServiceImpl.getActivityRuntime(anyInt())).thenReturn(new ActivityRuntimeDto());
        ActivityResponseDto<ActivityRuntimeDto> actual=  activityRuntimeController.getActivityRuntime(1);
        ActivityResponseDto<ActivityRuntimeDto> expected = new ActivityResponseDto<>();
        expected.setMessage(ActivityConstants.SUCCESS);
        expected.setResponseCode(200);
        expected.setData(new ActivityRuntimeDto());
        assertEquals(actual,expected);

    }

    @Test
    public void testGetAllActivityRunTime() {
        when(activityRuntimeServiceImpl.getActivityRuntime(anyInt())).thenReturn(new ActivityRuntimeDto());
        ActivityResponseDto<ActivityRuntimeDto> actual=  activityRuntimeController.getActivityRuntime(1);
        ActivityResponseDto<ActivityRuntimeDto> expected = new ActivityResponseDto<>();
        expected.setMessage(ActivityConstants.SUCCESS);
        expected.setResponseCode(200);
        expected.setData(new ActivityRuntimeDto());
        assertEquals(actual,expected);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme