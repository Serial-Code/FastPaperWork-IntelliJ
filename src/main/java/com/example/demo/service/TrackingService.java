package com.example.demo.service;

import com.example.demo.entity.Tracking;
import com.example.demo.repository.TrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackingService {

    @Autowired
    private TrackingRepository trackingRepository;


    public List<Tracking> getTrackings(){
        return trackingRepository.findAll();
    }

    public Tracking save(Tracking tracking){
        return trackingRepository.save(tracking);
    }

    public Tracking getTraking(Integer id){
        return trackingRepository.findById(id).get();
    }

    public Tracking updateTracking(Tracking tracking){
        return trackingRepository.save(tracking);
    }

    public void deleteTracking(Integer id){
        trackingRepository.deleteById(id);
    }


}
