package sactio.reminderapi.logic.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.logic.impl.ActivityRuntimeLogicImpl;
import sactio.reminderapi.repository.ActivityRuntimeRepository;

public class ActivityRuntimeLogicImplTest {
    @Mock
    ActivityRuntimeRepository activityRuntimeRepository;
    @InjectMocks
    ActivityRuntimeLogicImpl activityRuntimeLogicImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInsertActivityRuntime() throws Exception {
//        activityRuntimeLogicImpl.insertActivityRuntime(new ActivityRuntimeDto());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme