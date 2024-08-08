package com.sstech.mmtp.MakeMyTravelPlan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "MMTP_PLAN_CATEGORY")
@Data
public class PlanCategory {

    @Id
    @SequenceGenerator(name = "ctgrygen", sequenceName = "plancatgry_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "ctgrygen", strategy = GenerationType.SEQUENCE)
    @Column(name = "CTGRY_ID")
    private Integer categoryId;

    @Column(name = "CTGRY_NAME", length = 30)
    private String categoryName;

    @Column(name = "CTGRY_ACTIVE_SWITCH", length = 20)
    private String active_switch="active";

    @Column(name = "CTGRY_CREATED_DATE", updatable = false, insertable = true)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "CTGRY_UDPATED_DATE", updatable = true, insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "CTGRY_CREATED_BY", length = 20)
    private String createdBy;

    @Column(name = "CTGRY_UPDATED_BY", length = 20)
    private String updatedBy;
	
}
