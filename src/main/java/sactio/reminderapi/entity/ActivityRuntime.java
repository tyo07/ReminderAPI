package sactio.reminderapi.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@ToString
@Table(name = "ACTIVITY_RUNTIME")
public class ActivityRuntime {

    @Id
    @Column(name = "activity_id", nullable = false)
    private String activityId;
    @Column(name = "start_time", nullable = false)
    private String startTime;
    @Column(name = "end_time", nullable = false)
    private String endTime;
}
