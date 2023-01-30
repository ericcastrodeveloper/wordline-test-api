package com.example.wordlinetestapi.service;

import java.math.BigInteger;
import java.util.List;

public interface PerfectNumberService {
    List<BigInteger> getPerfectNumbers(List<BigInteger> numbers);
}
