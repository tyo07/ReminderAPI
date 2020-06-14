package sactio.reminderapi.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.entity.ActivityEntity;
import sactio.reminderapi.service.impl.ActivityServiceImpl;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class ActivityEntityControllerTest {
    @Mock
    ActivityServiceImpl activityServiceImpl;
    @InjectMocks
    ActivityController activityController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetActivity() throws Exception {
        when(activityServiceImpl.getListActivityId(anyString())).thenReturn(Collections.<ActivityEntity>singletonList(new ActivityEntity()));

        ActivityResponseDto result = activityController.getActivity("activity");
        ActivityResponseDto expected = new ActivityResponseDto();
        expected.setResponseCode("200");
        expected.setActivityEntityDetails(Collections.<ActivityEntity>singletonList(new ActivityEntity()));
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetAllActivity() throws Exception {
        when(activityServiceImpl.getAllActivities()).thenReturn(Arrays.<ActivityEntity>asList(new ActivityEntity()));

        ActivityResponseDto result = activityController.getAllActivity();
        ActivityResponseDto expected = new ActivityResponseDto();
        expected.setResponseCode("200");
        expected.setActivityEntityDetails(Collections.<ActivityEntity>singletonList(new ActivityEntity()));
        Assert.assertEquals(expected, result);
    }

    @Test
    @Ignore
    public void testInsertActivity() throws Exception {
        ActivityResponseDto result = activityController.insertActivity(new ActivityDto());
        Assert.assertEquals(new ActivityResponseDto(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme