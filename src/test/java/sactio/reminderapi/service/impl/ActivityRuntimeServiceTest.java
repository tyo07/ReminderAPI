package sactio.reminderapi.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.logic.ActivityRuntimeLogic;
import sactio.reminderapi.service.impl.ActivityRuntimeServiceImpl;

public class ActivityRuntimeServiceTest {
    @Mock
    ActivityRuntimeLogic activityRuntimeLogic;
    @InjectMocks
    ActivityRuntimeServiceImpl activityRuntimeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInsertActivityRuntime() throws Exception {
//        activityRuntimeServiceImpl.insertActivityRuntime(new ActivityRuntimeDto());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme