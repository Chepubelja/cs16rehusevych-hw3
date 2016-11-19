package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] arrayOne;
    public BaseArray(Object[] arrayOne) {
        this.arrayOne = arrayOne;
    }

    public Object[] toArray() {
        return arrayOne;
    }

    public String operationDescription() {
        return null;
    }

    public int size() {
        return arrayOne.length;
    }

}
