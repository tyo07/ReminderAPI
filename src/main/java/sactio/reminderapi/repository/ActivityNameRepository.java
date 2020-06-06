package sactio.reminderapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sactio.reminderapi.entity.ActivityName;

import java.util.List;

@Repository
public interface ActivityNameRepository extends JpaRepository<ActivityName, String> {
    List<ActivityName> findByActivityId(String activityId);
}
