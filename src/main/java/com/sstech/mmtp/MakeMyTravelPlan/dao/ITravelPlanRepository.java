package com.sstech.mmtp.MakeMyTravelPlan.dao;

import com.sstech.mmtp.MakeMyTravelPlan.Entity.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {
}
