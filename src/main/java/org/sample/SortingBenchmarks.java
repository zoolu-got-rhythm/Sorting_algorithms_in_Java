package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(value = 0, warmups = 0)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SortingBenchmarks {
    @Benchmark
    public void testInMs(){
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    @Fork(value = 0, warmups = 0)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testBubbleSort(Blackhole bh){
        bh.consume(Sort.bubble(new int[]{2, 8, 2, 6, 4, 5, 6, 3, 1, 3}));
    }

    @Benchmark
    @Fork(value = 0, warmups = 0)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testMergeSort(Blackhole bh){
        bh.consume(Sort.merge(new int[]{2, 8, 2, 6, 4, 5, 6, 3, 1, 3}));
    }
}
