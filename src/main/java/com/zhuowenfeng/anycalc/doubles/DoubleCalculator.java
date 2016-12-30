package com.zhuowenfeng.anycalc.doubles;

import com.zhuowenfeng.applications.twosigma.calculator.Calculator;
import com.zhuowenfeng.applications.twosigma.calculator.Operand;
import com.zhuowenfeng.applications.twosigma.calculator.Operator;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class DoubleCalculator extends Calculator<Double> {

  @Override
  protected Operand<Double> parseOperand(String tokenString) {
    return new Operand<>(Double.valueOf(tokenString));
  }

  @Override
  protected Operator<Double> parseOperator(String tokenString) {
    return DoubleOperatorFactory.getInstance().newOperator(tokenString);
  }

}
