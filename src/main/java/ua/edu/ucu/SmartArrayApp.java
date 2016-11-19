package ua.edu.ucu;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SortDecorator;

import java.util.Arrays;

public class SmartArrayApp {
    private MyPredicate myPredicate;
    private static int a = 4;
    private static int b = 2;
    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object oOne, Object oTwo) {
                return ((Integer) oOne) - ((Integer) oTwo);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]
        sa = new DistinctDecorator(sa);

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }
    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
            Student[] students) {
        SmartArray sa = new BaseArray(students);
        MyPredicate checkOne = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == b;
            }
        };
        MyPredicate checkTwo = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getGPA() >= a;
            }
        };
        MyComparator comp = new MyComparator() {
            @Override
            public int compare(Object oOne, Object oTwo) {
                return (((Student) oOne).getSurname().compareTo(
                        ((Student) oTwo).getSurname()));
            }
        };
        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname()
                        + " " + ((Student) t).getName();
            }
        };
//        Object[] objects = new Object[students.length];
//        int counter = 0;
//        for (int i = 0; i < students.length; i++){
//            if (check1.test(students[i]) && (check2.test(students[i]))){
//                objects[counter] = students[i];
//                counter++;}
//        }
//        String[] finish1 = new String[students.length - counter];
        sa = new FilterDecorator(sa, checkOne);
        sa = new FilterDecorator(sa, checkTwo);
        sa = new DistinctDecorator(sa);
        sa = new SortDecorator(sa, comp);
        sa = new MapDecorator(sa, func);
        Object[] result = sa.toArray();
        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        for (Object jo: result) {
            System.out.println((String) jo);
        }
        return Arrays.copyOf(result, result.length, String[].class);
    }
}