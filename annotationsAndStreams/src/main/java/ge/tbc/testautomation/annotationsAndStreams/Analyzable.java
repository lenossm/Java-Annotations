package ge.tbc.testautomation.annotationsAndStreams;

import java.lang.annotation.Target;

public class Analyzable {

    @VariableNameAnnotation(name = "IntegerValue")
    private int integerValue;

    @VariableNameAnnotation(name = "DoubleValue")
    private double doubleValue;

    @VariableNameAnnotation(name = "StringValue")
    private String stringValue;

    @VariableNameAnnotation(name = "BooleanValue")
    private boolean booleanValue;

    @VariableNameAnnotation(name = "LongValue")
    private long longValue;

    @VariableNameAnnotation(name = "ShortValue")
    private short shortValue;

    @VariableNameAnnotation(name = "FloatValue")
    private float floatValue;


    @VariableNameAnnotation
    private char charValue;

    @VariableNameAnnotation(name = "Another name")
    private byte byteValue;

    @VariableNameAnnotation(name = "ListValue")
    private java.util.List<String> listValue;
}
