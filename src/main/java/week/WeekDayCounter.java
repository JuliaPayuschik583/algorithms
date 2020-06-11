package week;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WeekDayCounter {

    private String solution(final List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            return String.valueOf(list.get(0));
        }

        final Set<Integer> set = new TreeSet<Integer>() {{
            addAll(list);
        }};

        final StringBuilder result = new StringBuilder();

        final List<Integer> weekDays = new ArrayList<>(set);

        boolean next = false;
        boolean add = false;
        result.append(weekDays.get(0));

        for (int i = 1; i < weekDays.size(); i++) {
            Integer day1 = weekDays.get(i - 1);
            Integer day2 = weekDays.get(i);

            int diff = day2 - day1;
            if (diff == 1) {
                //next -
                next = true;
            } else {
                if (next) {
                    result.append("-").append(day1).append(",").append(day2);
                    next = false;
                    add = true;
                } else {
                    if (i > 1) {
                        if (add) {
                            add = false;
                            result.append(",").append(day2);
                        } else {
                            result.append(",").append(day2);
                        }
                    } else {
                        result.append(",").append(day2);
                    }
                }
            }
            if (i + 1 == weekDays.size()) {
                //last element
                if (diff == 1) {
                    result.append("-").append(day2);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        WeekDayCounter main = new WeekDayCounter();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        String result = main.solution(list);
        System.out.println(result);
    }
}
