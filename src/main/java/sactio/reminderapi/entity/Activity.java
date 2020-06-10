package sactio.reminderapi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ACTIVITY")
public class Activity {

    @Id
    @Column(name = "activity_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long activityId;
    @Column(name = "activity_name", nullable = false)
    private String activityName;
}
