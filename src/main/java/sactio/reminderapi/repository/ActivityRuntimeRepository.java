package sactio.reminderapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sactio.reminderapi.entity.ActivityRuntime;


@Repository
public interface ActivityRuntimeRepository extends JpaRepository<ActivityRuntime, String> {

}
