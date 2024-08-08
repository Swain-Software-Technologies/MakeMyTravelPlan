package com.sstech.mmtp.MakeMyTravelPlan.service.impl;

import com.sstech.mmtp.MakeMyTravelPlan.Entity.PlanCategory;
import com.sstech.mmtp.MakeMyTravelPlan.Entity.TravelPlan;
import com.sstech.mmtp.MakeMyTravelPlan.dao.IPlanCategoryRepository;
import com.sstech.mmtp.MakeMyTravelPlan.dao.ITravelPlanRepository;
import com.sstech.mmtp.MakeMyTravelPlan.service.ITravelPlanMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TravelPlanMgmtService implements ITravelPlanMgmtService {

    @Autowired
    private ITravelPlanRepository  travelPlanRepository;
    @Autowired
    private IPlanCategoryRepository  planCategoryRepository;

    @Override
    public String registerTravelPlan(TravelPlan travelPlan) {
        TravelPlan savedPlan = travelPlanRepository.save(travelPlan);
        if(savedPlan.getPlanId() != null){
            return "Travel paln has registered with id " +savedPlan.getPlanId();
        }
        return "Unable to register Travel plan";
    }

    @Override
    public Map<Integer, String> getTravelPlanCategories() {
        List<PlanCategory> planCategories = planCategoryRepository.findAll();
        Map<Integer, String>  categoriesMap = new HashMap<Integer, String>();
        planCategories.forEach(category ->{
            categoriesMap.put(category.getCategoryId(), category.getCategoryName());
        });
        return categoriesMap;
    }

    @Override
    public List<TravelPlan> showAllTravelPlans() {
        List<TravelPlan> travelPlanList =  travelPlanRepository.findAll();
        return travelPlanList;
    }

    @Override
    public TravelPlan showTravelPlanById(Integer id) {
        return null;
    }

    @Override
    public String updateTravelPlan(TravelPlan plan) {
        return "";
    }

    @Override
    public String deleteTravelPlan(TravelPlan travelPlan) {
        return "";
    }

    @Override
    public String deleteTravelPlanStatus(Integer palnId, String status) {
        return "";
    }
}
