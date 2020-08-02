package local.nix.module.project.firstUniqueName;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Ann", "Julia", "Andrew", "Kate", "Ann", "Andrew", "Chack", "Kate");

        String unique = list.get(0);

        Map<String, Integer> map = new HashMap<>();

        for(int i = list.size()-1; i > 0; i--) {
            String current = list.get(i);
            if(!map.containsKey(current)) {
                unique = current;
            }
            map.put(current, 1);
        }

        System.out.println(unique);

    }
}
