package com.example.demo.controller;


import com.example.demo.entity.Tracking;
import com.example.demo.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TrackingViewController {

    @Autowired
    private TrackingService trackingService;


    @GetMapping("/tracking/all")
    public String getTrakings(Model model){
        List<Tracking> trackings = trackingService.getTrackings();
        model.addAttribute("trackings", trackings);
        return "tracking/all";
    }

    @GetMapping("/tracking/new")
    public String showNewTracking(Model model){
        model.addAttribute("tracking", new Tracking());
        return "tracking/new";
    }

    @PostMapping("/tracking/save")
    public String newTracking(Tracking tracking){
        trackingService.save(tracking);
        return "redirect:/tracking/all";
    }

    @GetMapping("/tracking/update/{id}")
    public String showUpdateTracking(@PathVariable Integer id, Model model){
       model.addAttribute("tracking", trackingService.getTraking(id));
        return "tracking/update";
    }

    @PostMapping("/tracking/update/{id}")
    public String udpateTracking(@PathVariable Integer id, Tracking tracking){
        tracking.setId(id);
        trackingService.updateTracking(tracking);
        return "redirect:/tracking/all";
    }

    @GetMapping("/tracking/delete/{id}")
        public String deleteTracking(@PathVariable Integer id){
            trackingService.deleteTracking(id);
            return "redirect:/tracking/all";
        }




}
