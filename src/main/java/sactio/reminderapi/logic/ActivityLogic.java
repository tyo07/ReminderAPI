package sactio.reminderapi.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sactio.reminderapi.entity.ActivityName;
import sactio.reminderapi.repository.ActivityNameRepository;

import java.util.List;
@Component

public class ActivityLogic {

    @Autowired
    ActivityNameRepository activityNameRepository;

    public List<ActivityName> getListActivityId(String activityId) {
        return activityNameRepository.findByActivityId(activityId);
    }
}
