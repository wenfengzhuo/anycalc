package com.zhuowenfeng.anycalc;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public interface OperatorFactory<T> {

  Operator<T> newOperator(String tokenString);

  void register(Operator<T> instance);

}
