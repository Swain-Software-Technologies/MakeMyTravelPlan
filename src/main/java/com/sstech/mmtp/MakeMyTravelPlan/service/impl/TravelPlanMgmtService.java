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
import java.util.Optional;

@Service
public class TravelPlanMgmtService implements ITravelPlanMgmtService {

    @Autowired
    private ITravelPlanRepository  travelPlanRepository;
    @Autowired
    private IPlanCategoryRepository  planCategoryRepository;

    @Override
    public String registerTravelPlan(TravelPlan travelPlan) {
        TravelPlan savedPlan = travelPlanRepository.save(travelPlan);
        /*
        if(savedPlan.getPlanId() != null){
            return "Travel paln has registered with id " +savedPlan.getPlanId();
        }
        return "Unable to register Travel plan";

         */
        return  savedPlan.getPlanId()!=null?"Travel plan has been saved with : " +savedPlan.getPlanId() : "Unable to register the Travel Plan";
    }

    @Override
    public List<TravelPlan> showAllTravelPlans() {
        List<TravelPlan> travelPlanList =  travelPlanRepository.findAll();
        return travelPlanList;
    }

    @Override
    public TravelPlan showTravelPlanById(Integer id) {
    /*
       Optional<TravelPlan> travelPlan = travelPlanRepository.findById(id);
       if(travelPlan.isPresent()){
           return travelPlan.get();
       } else if(travelPlan.isEmpty()){
            throw new  IllegalArgumentException("Plan ID not found");
       }
     */
        return travelPlanRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Plan ID not found"));
    }

    @Override
    public String updateTravelPlan(TravelPlan plan) {
        Optional<TravelPlan> availablePlan = travelPlanRepository.findById(plan.getPlanId());
        if(availablePlan.isPresent()){
            travelPlanRepository.save(plan);
            return plan.getPlanId() + " Travel plan has been updated";
        } else {
            return plan.getPlanId() + " Unable to update Travel plan";
        }
    }

    @Override
    public String deleteTravelPlan(Integer planId) {
        Optional<TravelPlan> travelPlan = travelPlanRepository.findById(planId);
        if(travelPlan.isPresent()) {
            travelPlanRepository.deleteById(planId);
            return planId + " Travel plan delete successfully";
        } else {
            return planId + " Unable to delete Travel plan";
        }
    }

    @Override
    public String changeTravelPlanStatus(Integer planId, String status) {
        Optional<TravelPlan> tpById = travelPlanRepository.findById(planId);
        if(tpById.isPresent()){
            TravelPlan plan = tpById.get();
            plan.setActiveSwitch(status);
            travelPlanRepository.save(plan);
            return planId + " Travel plan status got changed successfully";
        } else  {
            return planId + " Travel plan status got changed successfully";
        }

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
}
