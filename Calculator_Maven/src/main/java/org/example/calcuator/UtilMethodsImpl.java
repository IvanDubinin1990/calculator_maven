package org.example.calcuator;

import lombok.extern.java.Log;

@Log
public class UtilMethodsImpl implements UtilMethods {

    private final ConstantNumber constantNumber = new ConstantNumber();

    public String printResult(Double variable_1, String action_1, Double variable_2) {
        Model model = modelInitialization(variable_1, action_1, variable_2);
        Action action = new ActionImpl(model);
        return switch (model.getAction()) {
            case "-" -> "Answer: " + action.subtraction(model);
            case "+" -> "Answer: " + action.addition(model);
            case "/" -> "Answer: " + action.division(model);
            case "*" -> "Answer: " + action.multiplication(model);
            default -> "Uncorrected action";
        };
    }

    public String convertingAndPrintResult(Double variable_1, String action_1, Double variable_2) {
        Model model = modelInitialization(variable_1, action_1, variable_2);
        Action action = new ActionImpl(model);
        ArabicNumber arabicNumber = new ArabicNumber();
        switch (model.getAction()) {
            case "-" -> {
                Double subtraction = action.subtraction(model);
                return "Answer: " + arabicNumber.getArabicMapConverter().get(subtraction);
            }
            case "+" -> {
                Double addition = action.addition(model);
                return "Answer: " + arabicNumber.getArabicMapConverter().get(addition);
            }
            case "/" -> {
                Double division = action.division(model);
                return "Answer: " + arabicNumber.getArabicMapConverter().get(division);
            }
            case "*" -> {
                Double multiplication = action.multiplication(model);
                return "Answer: " + arabicNumber.getArabicMapConverter().get(multiplication);
            }
            default -> {
                throw new RuntimeException("Uncorrected the expression");
            }
        }
    }

    public Model modelInitialization(Double variable_1, String action_1, Double variable_2) {
        Model model = new Model();
        model.setVariable_1(variable_1);
        model.setAction(action_1);
        model.setVariable_2(variable_2);
        return model;
    }

    public String getResult(String[] strings) {

        if (strings.length != 3) {
            throw new RuntimeException("Uncorrected count of symbols");
        }

        if ((constantNumber.getARABIC_NUMERALS().contains(strings[0]) && constantNumber.getROMAN_NUMERALS().contains(strings[2])) ||
                (constantNumber.getROMAN_NUMERALS().contains(strings[0]) && constantNumber.getARABIC_NUMERALS().contains(strings[2]))) {
            throw new RuntimeException("The numbers must be of the same format (two Arabic or two Roman)");
        }

        checkExpression(Double.parseDouble(strings[0]), strings[1], Double.parseDouble(strings[2]));

        if (constantNumber.getROMAN_NUMERALS().contains(strings[0]) && constantNumber.getROMAN_NUMERALS().contains(strings[2])) {
            ArabicNumber arabicNumber = new ArabicNumber();
            Double variable_1 = arabicNumber.getArabicMap().get(strings[0]);
            String action_1 = strings[1];
            Double variable_2 = arabicNumber.getArabicMap().get(strings[2]);
            log.info("Done with Roman Numerals! Let's try again!");
            return convertingAndPrintResult(variable_1, action_1, variable_2);
        } else if (constantNumber.getARABIC_NUMERALS().contains(strings[0]) && constantNumber.getARABIC_NUMERALS().contains(strings[2])) {
            Double variable_1 = Double.parseDouble(strings[0]);
            String action_1 = strings[1];
            Double variable_2 = Double.parseDouble(strings[2]);
            log.info("Done with Arabic Numerals! Let's try again!");
            return printResult(variable_1, action_1, variable_2);
        } else {
            throw new RuntimeException("Uncorrected the expression. First and second number must be from 0 to 10");
        }
    }

    @Override
    public void checkExpression(Double variable_1, String action, Double variable_2) {
        Model model = new Model();
        model.setVariable_1(variable_1);
        model.setAction(action);
        model.setVariable_2(variable_2);
    }
}
