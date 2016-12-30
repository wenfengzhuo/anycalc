package com.zhuowenfeng.anycalc.doubles;


import com.zhuowenfeng.anycalc.Calculator;
import com.zhuowenfeng.anycalc.Operand;
import com.zhuowenfeng.anycalc.Operator;

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
