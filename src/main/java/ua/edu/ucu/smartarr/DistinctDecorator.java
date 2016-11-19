package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    public Object[] toArray() {
        Object[] distincted = new Object[size()];
        boolean already;
        int counter = 0;
        for (int i = 0; i < smartArray.size(); i++) {
            already = false;
            for (int k = i+1; k < smartArray.size(); k++) {
                if (smartArray.toArray()[i].equals(smartArray.toArray()[k])) {
                    already = true;
                    break;
                }
            }
            if (!already) {
                distincted[counter] = smartArray.toArray()[i];
                counter++;
            }
        }
        return distincted;
    }

    public String operationDescription() {
        return "";
    }

    public int size() {
        int newSize = smartArray.size();
        for (int k = 0; k < smartArray.size()-1; k++) {
            for(int j = k + 1; j < smartArray.size(); j++) {
                if (smartArray.toArray()[k].equals(smartArray.toArray()[j])) {
                    newSize--;
                    break;
                }
            }
        }
        return newSize;
    }
}