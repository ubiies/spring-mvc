package com.example.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LottoService {
    private int hits = 0;

    // 누군가가 방문했을 때 호출하는 메소드
    public int addHit() {
        hits++;
        return hits;
        // return ++hits;
    }

    public String lotto() {
        List<Integer> winningNums = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<6;i++){
            winningNums.add(random.nextInt(1,46));
        }
        return winningNums.toString();
    }
}
