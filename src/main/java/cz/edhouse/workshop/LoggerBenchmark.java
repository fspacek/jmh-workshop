package cz.edhouse.workshop;

import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Frantisek Spacek
 */
public class LoggerBenchmark {

    private static final Logger LOG = LoggerFactory.getLogger(LoggerBenchmark.class);

    @State(Scope.Thread)
    public static class LoggerState {
        String val;

        @Setup(Level.Iteration)
        public void prepare(){
            val =  RandomStringUtils.randomAlphanumeric(100);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testWithCheckDebug() {
        if(LOG.isDebugEnabled()){
            LOG.debug("Logging with check {}","edhouse");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testWithoutCheckDebug(LoggerState state) {
        LOG.debug("Logging without check {}", state);
    }

}
