package ge.tbc.testautomation.annotationsAndStreams;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Field[] fields = Analyzable.class.getDeclaredFields();


        System.out.println("Analyzable class fields:");
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }


        System.out.println("\nAnnotations on fields:");
        for (Field field : fields) {
            VariableNameAnnotation annotation = field.getAnnotation(VariableNameAnnotation.class);
            if (annotation != null) {
                System.out.println("Field: " + field.getName() + ", Annotation Name: " + annotation.name());
            } else {
                System.out.println("Field: " + field.getName() + " has NO annotation.");
            }
        }


        List<String> matchingFields = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(VariableNameAnnotation.class))
                .filter(field -> {
                    VariableNameAnnotation annotation = field.getAnnotation(VariableNameAnnotation.class);
                    return field.getName().equalsIgnoreCase(annotation.name());
                })
                .map(Field::getName)
                .collect(Collectors.toList());


        List<String> nonMatchingFields = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(VariableNameAnnotation.class))
                .filter(field -> {
                    VariableNameAnnotation annotation = field.getAnnotation(VariableNameAnnotation.class);
                    return !field.getName().equalsIgnoreCase(annotation.name());
                })
                .map(Field::getName)
                .collect(Collectors.toList());


        System.out.println("\nMatching Fields: " + matchingFields);
        System.out.println("Non-Matching Fields: " + nonMatchingFields);


        String unusedString = "Hello";
        int unusedInt = 42;
        double unusedDouble = 3.14;
        if (unusedString.length() > 0) {}
        if (unusedInt > 0) {}
        if (unusedDouble > 0) {}
    }
}
