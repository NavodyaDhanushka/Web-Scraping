package com.example.Q03.controller;

import com.example.Q03.dto.LotteryDto;
import com.example.Q03.entity.Lottery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Q03.service.LotteryService;
@RestController
public class LotteryController {

    @Autowired
    private LotteryService lotteryservice;

    @PostMapping("/addLottery")
    public Lottery addProduct(@RequestBody LotteryDto lotteryDto){
       return lotteryservice.addlottery(lotteryDto);
    }


}
