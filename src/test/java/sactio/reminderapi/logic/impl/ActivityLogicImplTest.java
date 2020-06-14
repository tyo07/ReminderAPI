package sactio.reminderapi.logic.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.ActivityEntity;
import sactio.reminderapi.repository.ActivityRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ActivityLogicImplTest {
    @Mock
    ActivityRepository activityRepository;
    @InjectMocks
    ActivityLogicImpl activityLogicImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetListActivityId() throws Exception {
        when(activityRepository.findByActivityId(anyString())).thenReturn(Arrays.<ActivityEntity>asList(new ActivityEntity()));

        List<ActivityEntity> result = activityLogicImpl.getListActivityId("activityId");
        Assert.assertEquals(Arrays.<ActivityEntity>asList(new ActivityEntity()), result);
    }

    @Test
    @Ignore
    public void testFindAllActivities() throws Exception {
        List<ActivityEntity> result = activityLogicImpl.findAllActivities();
        Assert.assertEquals(Arrays.<ActivityEntity>asList(new ActivityEntity()), result);
    }

    @Test
    public void testInsertActivities() throws Exception {
        activityLogicImpl.insertActivities(new ActivityDto());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme