package com.bitsis.test_demo.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.script.ScriptException;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ValueParserTest {

    @Autowired
    ValueParserService parser;

    @Test
    public void replaceValuesWithMatchOK() {
        final String expectedResult = "100 + 500";
        String expression = "${foo} + ${bar}";
        HashMap<String, String> storedValues = new HashMap<>();
        storedValues.put("foo", "100");
        storedValues.put("bar", "500");
        String result = parser.replaceValues(expression, storedValues);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void replaceValuesWithMatchNoParameters() {
        final String expectedResult = "$500 + {50}";
        String expression = "$500 + {50}";
        HashMap<String, String> storedValues = new HashMap<>();
        String result = parser.replaceValues(expression, storedValues);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evalIntegerExpression() throws ScriptException {
        final String expression = "2 + 1";
        assertThat(parser.evalDouble(expression)).isEqualTo(3.0);
    }
}
