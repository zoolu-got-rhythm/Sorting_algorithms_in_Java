package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 1)
@Warmup(iterations = 5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class SortingBenchmarks {

    @State(Scope.Thread)
    public static class smallDataSetState{

        public int[] dataSet;

        @Setup(Level.Invocation)
        public void setup(){
            this.dataSet = new int[]{2, 8, 2, 6, 4, 5, 6, 3, 1, 3})
        }
    }

    @State(Scope.Thread)
    public static class bigDataSetState{
        final private int arraySize = 1000;
        final private int intSize = 100;

        public int[] dataSet = new int[arraySize];

        @Setup(Level.Invocation)
        public void setup(){
            for (int i = 0; i < arraySize; i++){
                this.dataSet[i] = (int) Math.round(Math.random() * this.intSize);
            }

            this.dataSet = new int[]{2, 8, 2, 6, 4, 5, 6, 3, 1, 3})
        }
    }

    @Benchmark
    public void testBubbleSortSmallDataSet(smallDataSetState state, Blackhole bh){
        bh.consume(Sort.bubble(state.dataSet));
    }

    @Benchmark
    public void testBubbleSortLargeDataSet(bigDataSetState state, Blackhole bh){
        bh.consume(Sort.bubble(state.dataSet));
    }

    @Benchmark
    public void testMergeSortSmallDataSet(smallDataSetState state, Blackhole bh){
        bh.consume(Sort.merge(state.dataSet));
    }

    @Benchmark
    public void testMergeSortLargeDataSet(bigDataSetState state, Blackhole bh){
        bh.consume(Sort.merge(state.dataSet));
    }
}
