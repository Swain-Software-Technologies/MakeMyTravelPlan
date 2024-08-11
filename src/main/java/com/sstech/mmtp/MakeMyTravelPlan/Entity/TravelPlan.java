package com.sstech.mmtp.MakeMyTravelPlan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "MMTP_TRVLPLAN")
@Data
public class TravelPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLAN_ID")
    private Integer planId;

	@Column(name = "PLAN_NAME", length = 30)
    private String planName;

    @Column(name = "PLAN_MIN_BUDGET", length = 50)
    private String planMinimunBudget;

    @Column(name = "PLAN_DESC", length = 50)
    private String planDescription;

    @Column(name = "PLAN_CTGRY_ID")
    private Integer planCategoryId;

    @Column(name = "PLAN_CREATED_DATE", updatable = false, insertable = true)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "PLAN_UDPATED_DATE", updatable = true, insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "PLAN_CREATED_BY", length = 20)
    private String createdBy;

    @Column(name = "PLAN_UPDATED_BY", length = 20)
    private String updatedBy;

    @Column(name = "ACTIVE_SWITCH", length = 25)
    private String activeSwitch="active";
    }
