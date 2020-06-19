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
@Table(name = "activity")
public class ActivityEntity {

    @Id
    @Column(name = "activity_id", nullable = false)
    private Integer activityId;

    @Column(name = "activity_name", nullable = false)
    private String activityName;
}
