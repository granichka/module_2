package local.nix.module.project.dateMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Demo {


    public static void main(String[] args) {

        List<String> dates = Arrays.asList("2020/04/05", "05/04/2020", "04-05-2020");

        List<String> newDates = dates.stream().filter(s -> s.matches("[0-9]+[-/][0-9]+[-/][0-9]+")).map(Demo::convertDate).collect(Collectors.toList());
        System.out.println(newDates);
    }


    private static String convertDate(String s) {
        String result = "";
        if(s.contains("/")) {
            result = dateWithSlashHandling(s);
        } else if (s.contains("-")) {
            result = dateWithDashHandling(s);
        }
        return result;
    }

    private static String dateWithSlashHandling(String s) {
        String result = "";
        String[] date = s.split("/");
        int lengthOfFirstString = date[0].toCharArray().length;

        if(lengthOfFirstString == 4) {
            result = date[0] + date[1] + date[2];
        } else {
            result = date[2] + date[1] + date[0];
        }

        return result;
    }

    private static String dateWithDashHandling(String s) {

        String[] date = s.split("-");
        return date[2] + date[0] + date[1];
    }

}


