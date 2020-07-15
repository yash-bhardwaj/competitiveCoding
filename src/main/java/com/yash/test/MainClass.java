package com.yash.test;

import java.io.IOException;

public class MainClass {
    public static void main ( final String[] args ) throws IOException {
        int N = 4;
        int[] a = {1, 2};

        int total = getNumWays(N, a);
        System.out.println(total);
    }

    private static int getNumWays(int n, int[] a) {
        if (n == 0 ) return 1;
        int [] ways = new int[n+1];
        ways[0] = 1;
        for(int i = 1; i <= n; i++ ){
            int total = 0;
            for(int j : a )
                if (i - j >= 0) total += ways[i - j];
            ways[i] = total;
        }
        return ways[n];
    }
}
