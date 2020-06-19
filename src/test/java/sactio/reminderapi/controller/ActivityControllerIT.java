package sactio.reminderapi.controller;

import org.junit.After;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import sactio.reminderapi.ActivityApiApplication;
import sactio.reminderapi.config.MySQLBaseContainer;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.entity.ActivityEntity;
import sactio.reminderapi.repository.ActivityRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ActivityApiApplication.class)
@ContextConfiguration(initializers = MySQLBaseContainer.Initializer.class,
        classes = ActivityApiApplication.class)
@AutoConfigureMockMvc
public class ActivityControllerIT {


    @ClassRule
    public static MySQLContainer mysql = MySQLBaseContainer.getInstance();
    @Autowired
    private ActivityRepository activityRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mvc;

    @After
    public void resetDb() {
        activityRepository.deleteAll();
    }

    @Test
    public void testAllEmployees() {
        createTestActivity("drinkCoffee");
        createTestActivity("eatTakoyaki");

        ActivityResponseDto<?> activityResponseDto = this.restTemplate.getForObject("http://localhost:" + port + "/api/activity/get", ActivityResponseDto.class);
        assertThat(activityResponseDto.getData().toString(), is("{result=[{activityId=1, activityName=drinkCoffee}, {activityId=2, activityName=eatTakoyaki}]}"));
       
    }

//    @Test
//    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
//        createTestActivity("drinkCoffee");
//        createTestActivity("eatTakoyaki");
//
//        // @formatter:off
//        mvc.perform(get("/api/employees").contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
//                .andExpect(jsonPath("$[0].name", is("bob")))
//                .andExpect(jsonPath("$[1].name", is("alex")));
//        // @formatter:on
//    }

    //

    private void createTestActivity(String activityName) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setActivityName(activityName);
        activityRepository.saveAndFlush(activityEntity);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme