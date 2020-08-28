package Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author guoyf
 * @Date 2020/8/28
 * @describe
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
        }};
        List<String> strlist = Arrays.asList("zhangSan", "liSi", "wangWu");
        List<String> intList = Arrays.asList("1", "2", "3");
        // 使用 Steam 方式进行过滤：
        List filterList = list.stream().filter(v -> v % 2 == 0).collect(Collectors.toList());
        System.out.println(filterList);

        //构造 Stream 流的方式
        Stream stream = Stream.of("a", "b", "c");

        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        List<String> list2 = Arrays.asList(strArray);
        stream = list2.stream();
        /***
         * Stream 流的之间的转换
         */
        // 流转array
        Stream<String> stream2 = Stream.of("a", "b", "c");
        String[] st1 = stream2.toArray(String[]::new);
        // 转换成 Collection
        List<String> list1 = stream2.collect(Collectors.toList());
        List<String> list3 = stream2.collect(Collectors.toCollection(ArrayList::new));
        Set set1 = stream2.collect(Collectors.toSet());
        Stack stack = stream2.collect(Collectors.toCollection(Stack::new));
        // 转换成String
        String str = stream.collect(Collectors.joining()).toString();
        /***
         * Stream 流的 map 使用
         */
        // 转换大写
        List<String> list4 = strlist.stream().map(String::toUpperCase).collect(Collectors.toList());
        // 转换数据类型
        List<Integer> intList2 = intList.stream().map(Integer::valueOf).collect(Collectors.toList());
        // 获取平方
        List<Integer> list5 = Arrays.asList(new Integer[]{1,2,3,4,5});
        List<Integer> list6 = list5.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println("list6 = "+list6);

        /***
         * Stream 流的 filter 使用
         */


    }
}
