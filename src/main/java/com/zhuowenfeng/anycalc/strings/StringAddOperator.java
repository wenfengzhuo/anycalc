package com.zhuowenfeng.anycalc.strings;

import com.zhuowenfeng.anycalc.Operand;
import com.zhuowenfeng.anycalc.Operator;

import java.util.List;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class StringAddOperator implements Operator<String> {

  @Override
  public Operand<String> apply(List<Operand<String>> operands) {
    assert operands.size() == 2;
    return new Operand<>(operands.get(0).getValue() + operands.get(1).getValue());
  }

  @Override
  public int priority() {
    return 1;
  }

  @Override
  public int numOfOperands() {
    return 2;
  }

  @Override
  public String getRep() {
    return "+";
  }

}
