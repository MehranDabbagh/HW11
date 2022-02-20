package A_B;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingByStream {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>();
        names.add("mehran");
        names.add("ali");
        names.add("mohsen");
        names.add("hatef");
        names.add("mojtaba");
        names.add("mohammad");
        names.add("davood");
        names.add("reza");
        names.add("amir");
        //*A*//
        Map<Integer,List<String>> listMap=names.stream().collect(Collectors.groupingBy(String::length));
        listMap.forEach((key,value ) -> System.out.println(listMap.get(key)));
        //*B*//
        listMap.forEach((key,value ) -> System.out.println(listMap.get(key)+String.valueOf(key)));

    }
}
