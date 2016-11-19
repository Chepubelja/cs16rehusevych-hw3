package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    protected MyFunction myFunction;
    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(smartArray);
        this.myFunction = myFunction;
    }

    public Object[] toArray() {
        Object[] mapped = new Object[size()];
        for (int i = 0; i < size(); i++){
            mapped[i] = myFunction.apply(smartArray.toArray()[i]);
        }
        return mapped;
    }

    public String operationDescription() {
        return null;
    }

    public int size() {
        return smartArray.size();
    }
}
