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
            return result.append(weekDaysSet).toString();
        }

        Iterator iterator = weekDaysSet.iterator();

        boolean next = false;
        boolean isFirst = true;
        Integer day1 = null;
        Integer lastDay = null;
        boolean isLast = false;
        int diff = 0;
        while (iterator.hasNext() || isLast) {
            if (isFirst) {
                day1 = (Integer) iterator.next();
                result.append(day1);
                isFirst = false;
            } else {
                if (isLast) {
                    //last element
                    if (diff == 1) {
                        result.append("-").append(lastDay);//day2
                    }
                    isLast = false;
                } else {

                    day1 = (Integer) iterator.next();
                    Integer day2 = (Integer) iterator.next();

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

                    if (!iterator.hasNext()) {
                        isLast = true;
                        lastDay = day2;
                    }
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        final WeekDayCounter counter = new WeekDayCounter();
        Integer i = 2;
        String result = counter.solution(i);
        System.out.println(result);
    }
}
