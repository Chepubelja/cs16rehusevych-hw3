import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import java.util.Arrays;

public class Main {
public static void main(String[]args) {

    Integer[] integers = {-1, 2, 0, 1, -5, 3};
    SmartArray sa = new BaseArray(integers);
    MyFunction func = new MyFunction() {
        @Override
        public Object apply(Object t) {
            return 2 * ((Integer) t);
        }
    };

    sa = new MapDecorator(sa, func);
    System.out.println(Arrays.toString(sa.toArray()));

    Integer[] integersOne = {-1, 2, 0, 1, -5, 3};
    SmartArray saOne = new BaseArray(integersOne);
    MyPredicate pr = new MyPredicate() {
        @Override
        public boolean test(Object t) {
            return ((Integer) t) > 0;
        }
    };
    saOne = new FilterDecorator(saOne, pr);
    System.out.println(Arrays.toString(saOne.toArray()));

    Integer[] integersTwo = {-1, 2, 0, 1, -5, 3};
    SmartArray saTwo = new BaseArray(integersTwo);
    MyComparator cmp = new MyComparator() {
        @Override
        public int compare(Object oOne, Object oTwo) {
            return ((Integer) oOne) - ((Integer) oTwo);
        }
    };
    saTwo = new SortDecorator(saTwo, cmp);
    System.out.println(Arrays.toString(saTwo.toArray()));

//
//    MyFunction func1 = new MyPredicate(){
//        @Override
//        public Object test(Object t) {
//            return 2 * ((Integer) t);
//        }
//    };
//
    }
}
