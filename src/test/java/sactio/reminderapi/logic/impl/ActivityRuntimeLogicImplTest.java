package sactio.reminderapi.logic.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.entity.ActivityRuntimeEntity;
import sactio.reminderapi.repository.ActivityRuntimeRepository;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

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
    public void testFindRuntime_ByActivityId() throws Exception {
        when(activityRuntimeRepository.findByActivityId(anyInt())).thenReturn(Arrays.<ActivityRuntimeEntity>asList(new ActivityRuntimeEntity()));
        ActivityRuntimeDto result = activityRuntimeLogicImpl.findByActivityId(123);
        ActivityRuntimeDto expected = new ActivityRuntimeDto();
        expected.setActivityRuntimeEntityList(Collections.<ActivityRuntimeEntity>singletonList(new ActivityRuntimeEntity()));
        Assert.assertEquals(expected, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme