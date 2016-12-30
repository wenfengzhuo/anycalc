package com.zhuowenfeng.anycalc.strings;


import com.zhuowenfeng.anycalc.Operator;
import com.zhuowenfeng.anycalc.OperatorFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class StringOperatorFactory implements OperatorFactory<String> {

  private Map<String, Operator<String>> operatorMap = new HashMap<>();

  public StringOperatorFactory() {
    register(new StringAddOperator());
  }

  @Override
  public Operator<String> newOperator(String tokenString) {
    return operatorMap.get(tokenString);
  }

  @Override
  public void register(Operator<String> instance) {
    operatorMap.put(instance.getRep(), instance);
  }

  private static final StringOperatorFactory _instance = new StringOperatorFactory();

  public static StringOperatorFactory getInstance() {
    return _instance;
  }

}
