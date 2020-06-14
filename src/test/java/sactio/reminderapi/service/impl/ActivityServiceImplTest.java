package sactio.reminderapi.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.Activity;
import sactio.reminderapi.logic.ActivityLogic;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ActivityServiceImplTest {
    @Mock
    ActivityLogic activityLogic;
    @InjectMocks
    ActivityServiceImpl activityServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetListActivityId() throws Exception {
        when(activityLogic.getListActivityId(anyString())).thenReturn(Arrays.<Activity>asList(new Activity()));

        List<Activity> result = activityServiceImpl.getListActivityId("activityId");
        Assert.assertEquals(Arrays.<Activity>asList(new Activity()), result);
    }

    @Test
    public void testGetAllActivities() throws Exception {
        when(activityLogic.findAllActivities()).thenReturn(Arrays.<Activity>asList(new Activity()));

        List<Activity> result = activityServiceImpl.getAllActivities();
        Assert.assertEquals(Arrays.<Activity>asList(new Activity()), result);
    }

    @Test
    public void testInsertActivity() throws Exception {
        activityServiceImpl.insertActivity(new ActivityDto());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme