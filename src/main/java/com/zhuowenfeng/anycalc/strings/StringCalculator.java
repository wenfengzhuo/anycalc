package com.zhuowenfeng.anycalc.strings;


import com.zhuowenfeng.anycalc.Calculator;
import com.zhuowenfeng.anycalc.Operand;
import com.zhuowenfeng.anycalc.Operator;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class StringCalculator extends Calculator<String> {

  @Override
  protected Operand<String> parseOperand(String tokenString) {
    if (StringOperatorFactory.getInstance().newOperator(tokenString) != null) {
      return null;
    }
    return new Operand<>(tokenString);
  }

  @Override
  protected Operator<String> parseOperator(String tokenString) {
    return StringOperatorFactory.getInstance().newOperator(tokenString);
  }

}
