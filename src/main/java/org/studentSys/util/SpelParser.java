package org.studentSys.util;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelParser {
    private static ExpressionParser parser = new SpelExpressionParser();

    // el类型获取参数
    public static String getKey(String key, String[] parameterNames, Object[] args) {
        // key字符串解析为el表达式,并初始化赋值上下文
        Expression expression = parser.parseExpression(key);
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        if (args.length <= 0) {
            return null;
        }
        for (int i = 0; i < args.length; i++) {
            evaluationContext.setVariable(parameterNames[i], args[i]);
        }
        // 根据赋值上下文运算el表达式
        return expression.getValue(evaluationContext, String.class);
    }

    public static void main(String[] args) {
        String key = "#cyear + 'grades:' + #sid";
        int cyear = 1;
        int sid = 8146666;

        String[] paramsName = new String[]{"cyear", "sid"};

        Object[] _args = new Object[2];
        _args[0] = cyear;
        _args[1] = sid;

        System.out.println(SpelParser.getKey(key, paramsName, _args));
    }
}
