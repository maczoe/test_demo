package com.bitsis.test_demo.services;

import org.springframework.stereotype.Service;
import tk.pratanumandal.expr4j.ExpressionEvaluator;
import tk.pratanumandal.expr4j.OperatorRepository;
import tk.pratanumandal.expr4j.token.Operand;

import javax.script.*;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValueParserService {

    // Use Regular Exp to replace param values in a String
    public String replaceValues(String expression, HashMap<String,String> storedValues) {
        final Matcher m = Pattern.compile("\\$\\{(.*?)\\}").matcher(expression);
        final StringBuilder b = new StringBuilder(expression.length());
        while (m.find()) m.appendReplacement(b, storedValues.get(m.group(1)));
        m.appendTail(b);
        return b.toString();
    }

    // Eval an expression and get the result value
    public Double evalDouble(String expression) throws ScriptException {
        ExpressionEvaluator exprEval = new ExpressionEvaluator();
        return exprEval.evaluate(expression);
    }
}
