package com.zhuowenfeng.anycalc;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class Operand<T> {

  private T val;

  public Operand(T val) {
    this.val = val;
  }

  public T getValue() {
    return this.val;
  }

}
