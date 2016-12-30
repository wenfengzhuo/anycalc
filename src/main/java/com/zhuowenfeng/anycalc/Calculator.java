package com.zhuowenfeng.anycalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Wenfeng Zhuo (wz2366@columbia.edu)
 */
public abstract class Calculator<T> {

  private static final String DELIMITER_PATTERN = "\\s";

  public Result<T> eval(String expr) {
    expr = preprocess(expr);

    Stack<Operand<T>> operands = new Stack<>();
    Stack<Operator<T>> operators = new Stack<>();

    String[] tokenStrings = expr.split(DELIMITER_PATTERN);
    for (String tokenString : tokenStrings) {
      Operand<T> operand = null;
      try {
        operand = parseOperand(tokenString);
      } catch (Exception e) {
        // check whether the tokenString is operator next
      }
      if (operand != null) {
        operands.push(operand);
      } else {
        Operator<T> operator = null;
        try {
          operator = tryParseOperator(tokenString);
        } catch (Exception e) {
          // throw exception next
        }
        if (operator == null) {
         return new Result<>(false, null, "Invalid token in the expression: " + tokenString);
        }
        if (isLeftParenthesis(operator.getRep())) {
          operators.push(operator);
        } else if (isRightParenthesis(operator.getRep())) {
          while (!operators.isEmpty() && !isLeftParenthesis(operators.peek().getRep())) {
            calc(operands, operators);
          }
          operators.pop(); // pop "("
        } else {
          while (!operators.isEmpty() && operator.priority() <= operators.peek().priority()) {
            calc(operands, operators);
          }
          operators.push(operator);
        }
      }
    }
    while (!operators.isEmpty()) {
      calc(operands, operators);
    }
    if (operands.size() != 1) {
      return new Result<>(false, null, "Invalid expression, missing operators");
    }
    return new Result<>(true, operands.pop().getValue(), null);
  }

  private void calc(Stack<Operand<T>> operands, Stack<Operator<T>> operators) {
    Operator<T> operator = operators.pop();
    int numOfOperands = operator.numOfOperands();
    List<Operand<T>> opds = new ArrayList<>();
    while (numOfOperands-- > 0) {
      if (operands.isEmpty()) {
        throw new RuntimeException("Missing operands for operator " + operator.getRep());
      }
      opds.add(0, operands.pop());
    }
    operands.push(operator.apply(opds));
  }

  protected String preprocess(String expr) {
    expr = expr.replaceAll(DELIMITER_PATTERN + "+", " "); // Replace multiple delimiter as single one
    return expr;
  }

  protected Operator<T> tryParseOperator(String tokenString) {
    if ("(".equals(tokenString) || ")".equals(tokenString)) {
      return new ParenthesisOperator(tokenString);
    }
    return parseOperator(tokenString);
  }

  private boolean isLeftParenthesis(String rep) {
    return "(".equals(rep);
  }

  private boolean isRightParenthesis(String rep) {
    return ")".equals(rep);
  }

  protected abstract Operand<T> parseOperand(String tokenString);

  protected abstract Operator<T> parseOperator(String tokenString);

  private class ParenthesisOperator implements Operator<T> {

    private String rep;

    public ParenthesisOperator(String rep) {
      this.rep = rep;
    }

    @Override
    public Operand<T> apply(List<Operand<T>> operands) {
      return null;
    }

    @Override
    public int priority() {
      return 0;
    }

    @Override
    public int numOfOperands() {
      return 0;
    }

    @Override
    public String getRep() {
      return this.rep;
    }
  }

}
