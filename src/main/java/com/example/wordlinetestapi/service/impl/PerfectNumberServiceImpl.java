package com.example.wordlinetestapi.service.impl;

import com.example.wordlinetestapi.service.PerfectNumberService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PerfectNumberServiceImpl implements PerfectNumberService {
    @Override
    public List<BigInteger> getPerfectNumbers(List<BigInteger> numbers) {
        List<BigInteger> perfectNumbers = new ArrayList<>();

            numbers.stream().parallel().forEach(number -> {
                if (isPerfectNumber(number)) {
                    perfectNumbers.add(number);
                }
            });

        return perfectNumbers;
    }

    private boolean isPerfectNumber(BigInteger number) {
        // One way to calculate perfect number are 6 plus numbers > 9 using this form: (number - 1) / 9 terminate with 5 or 3
        if (number.equals(6))
            return true;
        if (number.compareTo(BigInteger.valueOf(9)) > 0) {
            // (number - 1) / 9
            BigDecimal result = new BigDecimal(number).subtract(BigDecimal.ONE).divide(BigDecimal.valueOf(9), 2, RoundingMode.HALF_UP);
            // result % 5 or 3 == 0 (terminate with 5 or 3)
            return result.remainder(BigDecimal.valueOf(3)).compareTo(BigDecimal.ZERO) == 0 || result.remainder(BigDecimal.valueOf(5)).compareTo(BigDecimal.ZERO) == 0;
        }
        else
            return false;
    }
}
