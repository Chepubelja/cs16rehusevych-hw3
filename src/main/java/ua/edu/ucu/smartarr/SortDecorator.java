package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    protected MyComparator comparator;
    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }

    public Object[] toArray() {
        Object[] sorted = smartArray.toArray();
        Arrays.sort(sorted, comparator);
        return sorted;
    }

    public String operationDescription() {
        return "";
    }

    public int size() {
        return smartArray.size();
    }
}