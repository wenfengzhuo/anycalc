package com.zhuowenfeng.anycalc;

import com.zhuowenfeng.anycalc.doubles.DoubleCalculator;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class DoubleCalculatorTest {

  public static void main(String[] args) {
    DoubleCalculator calculator = new DoubleCalculator();
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter you expression (should split operand and operator with whitespace): ");
    while (sc.hasNext()) {
      String expr = sc.nextLine();
      if ("exit".equals(expr)) {
        System.exit(0);
      }
      Result<Double> res = calculator.eval(expr);
      if (res.isSuccess()) {
        System.out.println("result = " + res.getValue());
      } else {
        System.out.println("result = N/A. Error: " + res.getError());
      }
      System.out.println();
      System.out.println("Please enter you expression (must split operand and operator with whitespace): ");
    }
  }

}
