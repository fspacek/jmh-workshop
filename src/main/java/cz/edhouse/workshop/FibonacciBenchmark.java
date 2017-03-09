package cz.edhouse.workshop;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/**
 * @author Frantisek Spacek
 */
public class FibonacciBenchmark  {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testRecursiveFibonacci30(Blackhole blackhole){
        blackhole.consume(recursiveFibonacci(30));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testLoopFibonacci30(Blackhole blackhole){
        blackhole.consume(loopFibonacci(30));
    }

    private static long recursiveFibonacci(int n) {
        if (n <= 1) return n;
        else return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }

    private static long loopFibonacci(int n) {
        int lo = 0;
        int hi = 1;
        for (int i = 0; i < n; i++) {
            hi = lo + hi;
            lo = hi - lo;
        }
        return lo;
    }

}
