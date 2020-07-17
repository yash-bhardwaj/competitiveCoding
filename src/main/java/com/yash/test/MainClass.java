package com.yash.test;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(final String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String[] strings = firstLine.split(" ");
        int arSize = Integer.parseInt(strings[0]);
        int queries = Integer.parseInt(strings[1]);
        String secondLine = sc.nextLine();
        List<Integer> sortedArr = Stream.of(secondLine.split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());

        while (queries > 0) {
            String[] query = sc.nextLine().split(" ");
            int cmd = Integer.parseInt(query[0]);
            int nThElement = Integer.parseInt(query[1]);
            int type = Integer.parseInt(query[2]);
            if (type == 0) {
                List<Integer> filtered = sortedArr.stream().filter(e -> e > cmd).collect(Collectors.toList());
                if (filtered.size() >= nThElement) System.out.println(filtered.get(nThElement - 1));
                else System.out.println(-1);
            }
            if (type == 1) {
                List<Integer> filtered = sortedArr.stream().filter(e -> e < cmd).collect(Collectors.toList());
                if (filtered.size() >= nThElement) System.out.println(filtered.get(filtered.size() - nThElement));
                else System.out.println(-1);
            }

            queries--;
        }
    }

}
