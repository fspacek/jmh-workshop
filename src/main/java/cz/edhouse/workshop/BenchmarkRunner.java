package cz.edhouse.workshop;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author Frantisek Spacek
 */
public class BenchmarkRunner {
    public static void main(String... args) throws RunnerException {
        final Options options = new OptionsBuilder().
                include("cz.edhouse.workshop.*")
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .forks(1)
                .threads(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .resultFormat(ResultFormatType.CSV)
                .jvmArgs("-verbose:gc")
                .build();
        new Runner(options).run();


    }
}
