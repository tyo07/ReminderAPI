package sactio.reminderapi.controller;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import sactio.reminderapi.ActivityApiApplication;
import sactio.reminderapi.config.MySQLBaseContainer;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.dto.ActivityRuntimeDto;
import sactio.reminderapi.entity.ActivityRuntimeEntity;
import sactio.reminderapi.repository.ActivityRuntimeRepository;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ActivityApiApplication.class)
@ContextConfiguration(initializers = MySQLBaseContainer.Initializer.class,
        classes = ActivityApiApplication.class)
@AutoConfigureMockMvc
public class ActivityRuntimeControllerIT {


    @ClassRule
    public static MySQLContainer mysql = MySQLBaseContainer.getInstance();
    @Autowired
    private ActivityRuntimeRepository activityRuntimeRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mvc;


    @Before
    public void setUp() {
        createTestActivityRuntime(1, "1200", "1300");
        createTestActivityRuntime(2, "1310", "1400");
    }

    @After
    public void resetDb() {
        activityRuntimeRepository.deleteAll();
    }


    @Test
    public void testGetAllActivities_return200_and_verifyResult() {
        ActivityResponseDto<ActivityRuntimeDto> activityResponseDto = this.restTemplate.exchange("http://localhost:" + port + "/api/activityruntime/get", HttpMethod.GET, null, new ParameterizedTypeReference<ActivityResponseDto<ActivityRuntimeDto>>() {
        }).getBody();
        assertThat(activityResponseDto.getResponseCode(), is(200));
        assertThat(activityResponseDto.getData().getActivityRuntimeEntityList().get(0).getActivityId(), is(1));
        assertThat(activityResponseDto.getData().getActivityRuntimeEntityList().get(1).getActivityId(), is(2));

    }

    @Test
    public void givenActivity_shouldReturn_200_and_containActivity() throws Exception {

        mvc.perform(get("/api/activityruntime/get").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("1200")))
                .andExpect(content().string(containsString("1300")))
                .andExpect(content().string(containsString("1310")))
                .andExpect(content().string(containsString("1400")));

    }

    @Test
    public void givenActivity_shouldReturn_200_and_jsonShouldMatch() throws Exception {

        mvc.perform(get("/api/activityruntime/get").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{'responseCode':200,'message':'Success','data':{'activityRuntimeEntityList':[{'activityId':1,'startTime':'1200','endTime':'1300'},{'activityId':2,'startTime':'1310','endTime':'1400'}]}})"));

    }

    @Test
    public void givenActivity_whenGetActivity_shouldReturn() throws Exception {

        mvc.perform(get("/api/activityruntime/get/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{'responseCode':200,'message':'Success','data':{'activityRuntimeEntityList':[{'activityId':1,'startTime':'1200','endTime':'1300'}]}})"));


        mvc.perform(get("/api/activityruntime/get/2").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{'responseCode':200,'message':'Success','data':{'activityRuntimeEntityList':[{'activityId':2,'startTime':'1310','endTime':'1400'}]}})"));

    }

    @Test
    public void givenActivity_whenGetActivity_notExist_shouldReturnEmpty() throws Exception {

        mvc.perform(get("/api/activityruntime/get/3").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{'responseCode':200,'message':'Success','data':{'activityRuntimeEntityList':[]}})"));

    }

    @Test
    public void insertActivity_shouldReturnSuccess() throws Exception {
        String jsonString = new JSONObject()
                .put("activityId", 1)
                .put("startTime", "1900")
                .put("endTime", "2000")
                .toString();

        mvc.perform(post("/api/activityruntime/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(jsonString))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(jsonString)));
    }


    private void createTestActivityRuntime(Integer activityId, String startTime, String endTime) {
        ActivityRuntimeEntity activityRuntimeEntity = new ActivityRuntimeEntity();
        activityRuntimeEntity.setActivityId(activityId);
        activityRuntimeEntity.setStartTime(startTime);
        activityRuntimeEntity.setEndTime(endTime);
        activityRuntimeRepository.saveAndFlush(activityRuntimeEntity);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme