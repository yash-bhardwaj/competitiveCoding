package com.yash.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainClass {
    /**
     * Given an array of n integers in the range 0 to k, process its input,
     * and then answer query about how many of n integers fall into range [a,b]?
     * <p>
     * First line of input contains n (no. of elements) and k (range)
     * Second line contains n elements
     * Third line contains q (number of query)
     * Fourth line contains a, b
     * <p>
     * Constraints : n, q <= 10^6, k <= 10^5, 0 <= a <= b <= 10^5 -1
     * <p>
     * Testcase #1 :
     * <p>
     * Input :
     * 6 10
     * 1 0 5 3 2 6
     * 3 0 0 1 2
     * 2 5
     * <p>
     * Output: 1 2 3
     */
    public static void main(final String[] args) throws IOException {
        /*Integer [] arr = {1, 0, 5, 3, 2, 6};
        int k = 10;
        Map<Integer, Integer> map =  new HashMap<>();
        List<Integer> list = Arrays.asList(arr);
        list.sort(Comparator.naturalOrder());

        System.out.println(list);
        List<Integer> collect = list.stream().filter(x -> x >= 2 && x<=5 ).collect(Collectors.toList());
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int m = Integer.parseInt(str.split(" ")[1]);
        str = br.readLine();
        String buf[] = str.split(" ");
        String buff[] = null;
        for (int i = 0; i < m; i++) {
            String[] query = br.readLine().split(" ");
            String cmd = query[0];
            int offSet = Integer.parseInt(query[2]);
            int index = Integer.parseInt(query[1]);

            if (cmd.equals("1")) buff = shiftToFront(index, offSet, buf);
            if (cmd.equals("2")) buff = shiftToBack(index, offSet, buf);
        }

        System.out.println(Math.abs(Long.parseLong(buf[0]) - Long.parseLong(buf[buf.length - 1])));
        System.out.println(String.join(" ", buf));
    }

    private static String[] shiftToFront(int index, int offSet, String[] buf) {
        String[] temp = getShitables(index, offSet, buf);
        int j = offSet - 1; // 4
        int i = index - 2;
        while (i >= 0) {
            buf[j] = buf[i];
            j--;
            i--;
        }

        for (i = 0; i < temp.length; i++) buf[i] = temp[i];
        return buf;
    }

    private static String[] shiftToBack(int index, int offSet, String[] buf) {
        String[] temp = getShitables(index, offSet, buf);
        int j = offSet;
        for (int i = index - 1; i < buf.length && j < buf.length; i++) {
            buf[i] = buf[j++];
        }
        j = temp.length;
        for (int i = 0; i < temp.length && j < buf.length; i++) {
            buf[buf.length - j] = temp[i];
            j--;
        }

        return buf;
    }

    private static String[] getShitables(int index, int offSet, String[] buf) {
        String[] temp = new String[offSet - index + 1];

        for (int i = 0; i <= offSet - index; i++) temp[i] = buf[i + index - 1];
        return temp;
    }


}
