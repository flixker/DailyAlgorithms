package me.fycus.nowcoder_leetcode;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens){
        Stack<String>  stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++)
            stack.push(tokens[i]);
        return eval(stack, stack.pop());
    }

    public int eval(Stack<String> stack, String s) {
        int op1;
        int op2;
        switch (s) {
            case "+":
                op2 = eval(stack, stack.pop());
                op1 = eval(stack, stack.pop());
                return op1 + op2;
            case "*":
                op2 = eval(stack, stack.pop());
                op1 = eval(stack, stack.pop());
                return op1 * op2;
            case "/":
                op2 = eval(stack, stack.pop());
                op1 = eval(stack, stack.pop());
                return op1 / op2;
            case "-":
                op2 = eval(stack, stack.pop());
                op1 = eval(stack, stack.pop());
                return op1 - op2;
            default:
                return Integer.valueOf(s);
        }
    }
}
