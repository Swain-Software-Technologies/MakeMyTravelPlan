package com.sstech.mmtp.MakeMyTravelPlan.controller;

import com.sstech.mmtp.MakeMyTravelPlan.Entity.TravelPlan;
import com.sstech.mmtp.MakeMyTravelPlan.service.ITravelPlanMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/travelplan")
public class TravelPlanController {

    @Autowired
    ITravelPlanMgmtService  planMgmtService;

    public TravelPlan travelPlan;

    @PostMapping("/register")
    public ResponseEntity<String> registerTravelPlan(@RequestBody TravelPlan travelPlan){
        try {
            String msg = planMgmtService.registerTravelPlan(travelPlan);
            return new ResponseEntity<String>(msg, HttpStatus.CREATED);

        } catch(Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAlltravelplan")
    public ResponseEntity<?> getAllTravelPlans() {
        try{
            List<TravelPlan> travelPlanList = planMgmtService.showAllTravelPlans();
            return new ResponseEntity<List<TravelPlan>>(travelPlanList, HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{planId}")
    public ResponseEntity<?> getAllTravelPlans(@PathVariable Integer planId) {

        try {
            TravelPlan plan = planMgmtService.showTravelPlanById(planId);
            return  new ResponseEntity<TravelPlan>(plan, HttpStatus.OK);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateTravelPlan")
    public ResponseEntity<?> updateTravelPlan(@RequestBody TravelPlan plan){
        try {
                String msg = planMgmtService.updateTravelPlan(plan);
                return new ResponseEntity<TravelPlan>(plan, HttpStatus.OK);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{planId}")
    public ResponseEntity<?> removeTravelPlanById(Integer planId) {
        try {
            String msg = planMgmtService.deleteTravelPlan(planId);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        } catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<?> changeTravelPlanStatus(Integer planId, String status){

        try{
            String msg = planMgmtService.changeTravelPlanStatus(planId, status);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/plan/categories")
    public ResponseEntity<?> getAllPlanCategories(){
        try{
            Map<Integer, String> travelPlanCategories = planMgmtService.getTravelPlanCategories();
            return new ResponseEntity<Map<Integer, String>>(travelPlanCategories, HttpStatus.OK);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
