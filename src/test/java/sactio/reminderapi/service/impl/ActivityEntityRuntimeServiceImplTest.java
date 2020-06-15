package sactio.reminderapi.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.logic.ActivityRuntimeLogic;

import static org.mockito.Mockito.*;

public class ActivityEntityRuntimeServiceImplTest {
    @Mock
    ActivityRuntimeLogic activityRuntimeLogic;
    @InjectMocks
    ActivityRuntimeServiceImpl activityRuntimeServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInsertActivityRuntime() throws Exception {
        activityRuntimeServiceImpl.insertActivityRuntime(new ActivityRuntimeDto());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme