package com.zhuowenfeng.anycalc.strings;

import com.zhuowenfeng.anycalc.Operand;
import com.zhuowenfeng.anycalc.Operator;

import java.util.List;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class StringMultiplyOperator implements Operator<String> {

  @Override
  public Operand<String> apply(List<Operand<String>> operands) {
    assert operands.size() == 2;
    String str = operands.get(0).getValue();
    int repeatedNum = Integer.parseInt(operands.get(1).getValue());
    StringBuilder sb = new StringBuilder();
    while (repeatedNum -- > 0) {
      sb.append(str);
    }
    return new Operand<>(sb.toString());
  }

  @Override
  public int priority() {
    return 2;
  }

  @Override
  public int numOfOperands() {
    return 2;
  }

  @Override
  public String getRep() {
    return "*";
  }

}
