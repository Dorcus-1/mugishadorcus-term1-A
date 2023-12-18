package rw.ac.rca.CalculatorLogic.services;

import rw.ac.rca.CalculatorLogic.exceptions.InvalidOperationException;

public interface IMathOperator {

    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
