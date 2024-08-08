package com.sstech.mmtp.MakeMyTravelPlan.controller;

import com.sstech.mmtp.MakeMyTravelPlan.Entity.TravelPlan;
import com.sstech.mmtp.MakeMyTravelPlan.service.ITravelPlanMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
