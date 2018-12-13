package com.galvanize.motel666sender.controller;

import com.galvanize.motel666sender.entity.UserEvent;
import com.galvanize.motel666sender.service.MotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class MotelController {

    @Autowired
    MotelService service;


    @PostMapping("/room/{userId}")
    public UserEvent reserveRoom(@PathVariable String userId) {
        return service.bookingRoom(userId);
    }

}
