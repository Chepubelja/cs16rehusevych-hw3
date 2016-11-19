package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate myPredicate;
    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        this.myPredicate = myPredicate;
    }

    public Object[] toArray() {
        Object[] filtered = new Object[size()];
        int counter = 0;
        for (int i = 0; i < smartArray.size(); i++) {
            if (myPredicate.test(smartArray.toArray()[i])) {
                filtered[counter] = smartArray.toArray()[i];
                counter++;
                //filtered[i] = myFunction.apply(smartArray.toArray()[i]);
            }
        }
        return filtered;
    }

    public String operationDescription() {
        return null;
    }

    public int size() {
        int newSize = 0;
        for (int i = 0; i < smartArray.size(); i++) {
            if (myPredicate.test(smartArray.toArray()[i])) {
                newSize++;
            }
        }
        return newSize;
    }
}
