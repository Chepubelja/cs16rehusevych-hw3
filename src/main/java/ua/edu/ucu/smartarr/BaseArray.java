package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    protected Object[] array1;
    public BaseArray(Object[] array1){
        this.array1 = array1;
    }

    public Object[] toArray() {
        return array1;
    }

    public String operationDescription() {
        return null;
    }

    public int size() {
        return array1.length;
    }

}
