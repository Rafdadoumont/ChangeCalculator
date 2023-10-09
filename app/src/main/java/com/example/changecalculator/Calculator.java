package com.example.changecalculator;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    public Map<ChangeEnum, Integer> calculateChange(double amountToPay, double amountPaid) {
        Map<ChangeEnum, Integer> changeMap = new HashMap<>();
        double changeAmount = amountPaid - amountToPay;

        if (changeAmount < 0) {
            return changeMap;
        }

        for (ChangeEnum changeEnum: ChangeEnum.values()) {
            while (changeEnum.getValue() <= changeAmount) {
                Integer count = changeMap.get(changeEnum);
                changeMap.put(changeEnum, ((count != null) ? ++count : 1));
                changeAmount -= changeEnum.getValue();
            }
        }

        return changeMap;
    }
}
