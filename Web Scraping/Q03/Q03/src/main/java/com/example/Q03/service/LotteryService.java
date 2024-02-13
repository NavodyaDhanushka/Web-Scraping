package com.example.Q03.service;

import com.example.Q03.dto.LotteryDto;
import com.example.Q03.entity.Lottery;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Q03.repository.LotteryRepository;

@Service
public class LotteryService {
    @Autowired
    private LotteryRepository lotteryRepository;
    public Lottery addlottery(LotteryDto lotteryDto) {
        Lottery lottery=new Lottery();
        try {
            String[] parts = lotteryDto.getUrl().split("/");


            String drawNo = parts[parts.length - 1];

            Document doc = Jsoup.connect(lotteryDto.getUrl()).get();

            Elements numbers = doc.select("div.BB ol.B li");

            lottery.setDrawNo(Integer.parseInt(drawNo));
            lottery.setName(lotteryDto.getName());
            lottery.setLetter(numbers.get(0).text());
            lottery.setNo1(Integer.parseInt(numbers.get(1).text()));
            lottery.setNo2(Integer.parseInt(numbers.get(2).text()));
            lottery.setNo3(Integer.parseInt(numbers.get(3).text()));
            lottery.setNo4(Integer.parseInt(numbers.get(4).text()));

            return lotteryRepository.save(lottery);



        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
