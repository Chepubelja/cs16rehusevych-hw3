import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import java.util.Arrays;

public class Main{
public static void main(String[]args){

    Integer[] integers = {-1, 2, 0, 1, -5, 3};
    SmartArray sa = new BaseArray(integers);
    MyFunction func = new MyFunction(){
        @Override
        public Object apply(Object t) {
            return 2 * ((Integer) t);
        }
    };

    sa = new MapDecorator(sa, func);
    System.out.println(Arrays.toString(sa.toArray()));

    Integer[] integers1 = {-1, 2, 0, 1, -5, 3};
    SmartArray sa1 = new BaseArray(integers1);
    MyPredicate pr = new MyPredicate() {
        @Override
        public boolean test(Object t) {
            return ((Integer) t) > 0;
        }
    };
    sa1 = new FilterDecorator(sa1, pr);
    System.out.println(Arrays.toString(sa1.toArray()));

    Integer[] integers2 = {-1, 2, 0, 1, -5, 3};
    SmartArray sa2 = new BaseArray(integers2);
    MyComparator cmp = new MyComparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Integer) o1) - ((Integer) o2);
        }
    };
    sa2 = new SortDecorator(sa2, cmp);
    System.out.println(Arrays.toString(sa2.toArray()));

//
//    MyFunction func1 = new MyPredicate(){
//        @Override
//        public Object test(Object t) {
//            return 2 * ((Integer) t);
//        }
//    };
//



}}
