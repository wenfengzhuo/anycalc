package com.zhuowenfeng.anycalc.doubles;


import com.zhuowenfeng.anycalc.Operator;
import com.zhuowenfeng.anycalc.OperatorFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class DoubleOperatorFactory implements OperatorFactory<Double> {

  private final Map<String, Operator<Double>> operatorMap = new HashMap<>();

  private DoubleOperatorFactory() {
    register(new DoubleAddOperator());
    register(new DoubleMinusOperator());
    register(new DoubleMultiplyOperator());
    register(new DoubleDivideOperator());
    register(new DoubleIncOperator());
  }

  @Override
  public Operator<Double> newOperator(String tokenString) {
    return operatorMap.get(tokenString);
  }

  @Override
  public void register(Operator<Double> instance) {
    operatorMap.put(instance.getRep(), instance);
  }


  private static final DoubleOperatorFactory _instance = new DoubleOperatorFactory();

  public static DoubleOperatorFactory getInstance() {
    return _instance;
  }

}
