# JMH (Java Microbenchmark Harness) Lightning Talk
* JMH is a Java harness for building, running, and analysing nano/micro/milli/macro benchmarks 
written in Java and other languages targeting the JVM.
* Developed by OpenJDK team
* Provides annotation driven API to easily develop correctly designed benchmarks

Hello world example:
    
```java
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testRecursiveFibonacci30(Blackhole blackhole){
        blackhole.consume(recursiveFibonacci(30));
    }

    private static long recursiveFibonacci(int n) {
        if (n <= 1) return n;
        else return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }
```
[Official samples](http://hg.openjdk.java.net/code-tools/jmh/file/ecd9e76155fe/jmh-samples)

Pitfalls of Java benchmarks:
* JIT
* [Loop optimizations](http://hg.openjdk.java.net/code-tools/jmh/file/f2e982b7c51b/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_11_Loops.java) 
* [dead-code elimination](http://hg.openjdk.java.net/code-tools/jmh/file/f2e982b7c51b/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_08_DeadCode.java)



Alternatives:
 * [Google Caliper](https://github.com/google/caliper)
 
 Resources:
 * [JMH vs Caliper: reference thread](https://groups.google.com/forum/#!msg/mechanical-sympathy/m4opvy4xq3U/7lY8x8SvHgwJ)
 * [How do I write a correct micro-benchmark in Java?](http://stackoverflow.com/a/513259/1134312)