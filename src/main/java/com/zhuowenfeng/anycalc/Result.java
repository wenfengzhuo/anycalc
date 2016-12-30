package com.zhuowenfeng.anycalc;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public class Result<T> {

  private boolean success;

  private T value;

  private String error;

  public Result(boolean success, T value, String error) {
    this.success = success;
    this.value = value;
    this.error = error;
  }

  public boolean isSuccess() {
    return success;
  }

  public T getValue() {
    return value;
  }

  public String getError() {
    return error;
  }
}
