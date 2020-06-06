package sactio.reminderapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ACTIVITY_NAME")
public class ActivityName {

    @Id
    @Column(name = "activity_id", nullable = false)
    private String activityId;
    @Column(name = "activity_name", nullable = false)
    private String activityName;
}
