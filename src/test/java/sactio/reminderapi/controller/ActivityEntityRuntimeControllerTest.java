package sactio.reminderapi.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.service.ActivityRuntimeService;

import static org.mockito.Mockito.*;

public class ActivityEntityRuntimeControllerTest {
    @Mock
    ActivityRuntimeService activityRuntimeService;
    @InjectMocks
    ActivityRuntimeController activityRuntimeController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore
    public void testInsertActivityRuntime() throws Exception {
        ActivityResponseDto result = activityRuntimeController.insertActivityRuntime(new ActivityRuntimeDto());
        Assert.assertEquals(new ActivityResponseDto(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme