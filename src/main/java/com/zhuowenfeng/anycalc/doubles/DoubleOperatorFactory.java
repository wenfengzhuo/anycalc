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
    DoubleAddOperator addOperator = new DoubleAddOperator();
    operatorMap.put(addOperator.getRep(), addOperator);
    DoubleIncOperator incOperator = new DoubleIncOperator();
    operatorMap.put(incOperator.getRep(), incOperator);
  }

  @Override
  public Operator<Double> newOperator(String tokenString) {
    return operatorMap.get(tokenString);
  }

  @Override
  public void register(String rep, Operator<Double> instance) {
    operatorMap.put(rep, instance);
  }


  private static final DoubleOperatorFactory _instance = new DoubleOperatorFactory();

  public static DoubleOperatorFactory getInstance() {
    return _instance;
  }

}
