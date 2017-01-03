package com.zhuowenfeng.anycalc;

import com.zhuowenfeng.anycalc.doubles.DoubleCalculator;
import com.zhuowenfeng.anycalc.strings.StringCalculator;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class MultipleCalculatorTest {

  public static void main(String[] args) {
    if (args.length < 1) {
      System.exit(0);
    }
    String calcType = args[0];
    if ("number".equals(calcType)) {
      execute(new DoubleCalculator());
    } else if ("string".equals(calcType)) {
      execute(new StringCalculator());
    } else {
      System.out.println(calcType + " calculator not implemented yet.");
    }
  }

  public static <T> void execute(Calculator<T> calculator) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter you expression: (should split operand and operator with whitespace)");
    while (sc.hasNext()) {
      String expr = sc.nextLine();
      if ("exit".equals(expr)) {
        System.exit(0);
      }
      Result<T> res = calculator.eval(expr);
      if (res.isSuccess()) {
        System.out.println("result = " + res.getValue());
      } else {
        System.out.println("result = N/A. Error: " + res.getError());
      }
      System.out.println();
      System.out.println("Please enter you expression: (must split operand and operator with whitespace)");
    }
  }

}
