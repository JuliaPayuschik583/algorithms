package week;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class WeekDayCounter {

    private String solution(Integer input) {
        if (input == null) {
            return "";
        }

        final Set<Integer> weekDaysSet = new TreeSet<>();

        while (input/10 > 0) {
            weekDaysSet.add(input % 10);
            input = input/10;
        }
        weekDaysSet.add(input);

        final StringBuilder result = new StringBuilder();

        if (weekDaysSet.size() == 1) {
            Iterator iterator = weekDaysSet.iterator();
            return result.append(iterator.next()).toString();
        }

        boolean next = false;
        boolean isFirst = true;
        Integer day0 = null;
        Integer day1 = null;
        int diff = 0;

        for (Iterator i = weekDaysSet.iterator(); i.hasNext();) {
            if (isFirst) {
                day1 = (Integer) i.next();
                result.append(day1);
                day0 = day1;
                isFirst = false;
            } else {
                day1 = day0;
                Integer day2 = (Integer) i.next();
                diff = day2 - day1;

                if (diff == 1) {
                    //next -
                    next = true;
                } else {
                    if (next) {
                        result.append("-").append(day1).append(",").append(day2);
                        next = false;
                    } else {
                        result.append(",").append(day2);
                    }
                }
                if (!i.hasNext()) {
                    if (diff == 1) {
                        result.append("-").append(day2);
                    }
                }
              day0 = day2;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        final WeekDayCounter counter = new WeekDayCounter();
        Integer i = 1234567;
        String result = counter.solution(i);
        System.out.println(result);
    }
}
