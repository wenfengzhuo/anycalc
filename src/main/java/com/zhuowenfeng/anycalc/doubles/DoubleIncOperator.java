package com.zhuowenfeng.anycalc.doubles;


import com.zhuowenfeng.anycalc.Operand;
import com.zhuowenfeng.anycalc.Operator;

import java.util.List;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class DoubleIncOperator implements Operator<Double> {

  @Override
  public Operand<Double> apply(List<Operand<Double>> operands) {
    assert operands.size() == 1;
    return new Operand<>(operands.get(0).getValue() + 1);
  }

  @Override
  public int priority() {
    return 3;
  }

  @Override
  public int numOfOperands() {
    return 1;
  }

  @Override
  public String getRep() {
    return "++";
  }

}
