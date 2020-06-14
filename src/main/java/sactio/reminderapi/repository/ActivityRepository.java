package sactio.reminderapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.entity.ActivityEntity;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, String> {
    List<ActivityEntity> findByActivityId(Integer activityId);
}
