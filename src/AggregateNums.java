import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Data {
    static final int [] input1 = {2,2,0,0,0,0,0,1};
    static final int [] input2 = {1,1,1,1,1,0};
    static final int [] input3 = {1,2,3,4,6,5,5,5,5,5,5,5,5,5,5,};

}
public class AggregateNums {

    public void reduceAndPrint(int [] arr){
        Stream<Integer> s = Arrays.stream(arr).boxed();
        Map<Integer,Long> countMap = s.collect(Collectors.groupingBy(Function.identity()
                , LinkedHashMap::new, Collectors.counting()));
        List<String> outputStrList = new ArrayList<String>();
        for (Map.Entry<Integer,Long> tuple: countMap.entrySet()){
           Integer num = tuple.getKey();
           Long count = tuple.getValue();
           if (count == 1){
               outputStrList.add(String.valueOf(num));
           } else{
               outputStrList.add(String.format("%d FOR %d",num,count));
           }
        }
        System.out.println(String.join(" ",outputStrList));

    }
    public static void main(String[] args) {
        AggregateNums ag = new AggregateNums();
        ag.reduceAndPrint(Data.input1);
        ag.reduceAndPrint(Data.input2);
        ag.reduceAndPrint(Data.input3);
    }
}
