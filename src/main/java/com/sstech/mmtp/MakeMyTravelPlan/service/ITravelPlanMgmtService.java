package com.sstech.mmtp.MakeMyTravelPlan.service;

import com.sstech.mmtp.MakeMyTravelPlan.Entity.TravelPlan;

import java.util.List;
import java.util.Map;

public interface ITravelPlanMgmtService {

    public String registerTravelPlan(TravelPlan travelPlan);
    public List<TravelPlan> showAllTravelPlans();
    public TravelPlan showTravelPlanById(Integer id);
    public String updateTravelPlan(TravelPlan plan);
    public String deleteTravelPlan(Integer  planId);
    public String changeTravelPlanStatus(Integer palnId, String status);
    public Map<Integer, String> getTravelPlanCategories();
}
