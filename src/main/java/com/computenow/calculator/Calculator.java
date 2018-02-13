package com.computenow.calculator;
import org.springframework.stereotype.Service;

/**
 * Calculator class
 */
@Service
public class Calculator {
    int sum(int a, int b) {
        return a + b;
    }
}
