package com.zhuowenfeng.anycalc;

import java.util.List;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public interface Operator<T>{

  Operand<T> apply(List<Operand<T>> operands);

  int priority();

  int numOfOperands();

  String getRep();

}
