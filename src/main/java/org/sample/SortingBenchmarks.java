package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 1)
@Warmup(iterations = 5)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class SortingBenchmarks {

    public interface StateContract{
        int[] getDataSet();
        void setup();
    }

    @State(Scope.Thread)
    public static class smallDataSetState implements StateContract{

        private int[] dataSet;

        @Override
        public int[] getDataSet() {
            return this.dataSet;
        }

        @Setup(Level.Invocation)
        public void setup(){
            this.dataSet = new int[]{2, 8, 2, 6, 4, 5, 6, 3, 1, 3};
        }
    }

    @State(Scope.Thread)
    public static class bigDataSetState implements StateContract{
        final private int arraySize = 1000;
        final private int intSize = 100;

        private int[] dataSet = new int[arraySize];

        @Override
        public int[] getDataSet() {
            return this.dataSet;
        }

        @Setup(Level.Invocation)
        public void setup(){
            for (int i = 0; i < arraySize; i++){
                this.dataSet[i] = (int) Math.round(Math.random() * this.intSize);
            }
        }
    }



    @Benchmark
    public void testBubbleSortSmallDataSet(smallDataSetState state, Blackhole bh){
        bh.consume(Sort.bubble(state.getDataSet()));
    }

    @Benchmark
    public void testBubbleSortLargeDataSet(bigDataSetState state, Blackhole bh){
        bh.consume(Sort.bubble(state.getDataSet()));
    }

    @Benchmark
    public void testMergeSortSmallDataSet(smallDataSetState state, Blackhole bh){
        bh.consume(Sort.merge(state.getDataSet()));
    }

    @Benchmark
    public void testMergeSortLargeDataSet(bigDataSetState state, Blackhole bh){
        bh.consume(Sort.merge(state.getDataSet()));
    }

    @Benchmark
    public void testQuickSortSmallDataSet(smallDataSetState state, Blackhole bh){
        bh.consume(Sort.quick(state.getDataSet()));
    }

    @Benchmark
    public void testQuickSortLargeDataSet(bigDataSetState state, Blackhole bh){
        bh.consume(Sort.quick(state.getDataSet()));
    }

    @Benchmark
    public void testSelectionSortSmallDataSet(smallDataSetState state, Blackhole bh){
        bh.consume(Sort.selection(state.getDataSet()));
    }

    @Benchmark
    public void testSelectionSortLargeDataSet(bigDataSetState state, Blackhole bh){
        bh.consume(Sort.selection(state.getDataSet()));
    }


}
