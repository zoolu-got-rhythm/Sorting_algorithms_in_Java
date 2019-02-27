///*
// * Copyright (c) 2014, Oracle America, Inc.
// * All rights reserved.
// *
// * Redistribution and use in source and binary forms, with or without
// * modification, are permitted provided that the following conditions are met:
// *
// *  * Redistributions of source code must retain the above copyright notice,
// *    this list of conditions and the following disclaimer.
// *
// *  * Redistributions in binary form must reproduce the above copyright
// *    notice, this list of conditions and the following disclaimer in the
// *    documentation and/or other materials provided with the distribution.
// *
// *  * Neither the name of Oracle nor the names of its contributors may be used
// *    to endorse or promote products derived from this software without
// *    specific prior written permission.
// *
// * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
// * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
// * THE POSSIBILITY OF SUCH DAMAGE.
// */
//
//package org.sample;
//
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//
//import java.util.concurrent.TimeUnit;
//
//public class MyBenchmark {
//
//    @Benchmark
//    public void testMethod() {
//        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
//        // Put your benchmark code here.
//    }
//
//    @Benchmark
//    @Fork(value = 0, warmups = 0)
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public void testInMs(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @State(Scope.Thread)
//    public static class smallDataSetState{
//
//        public int[] dataSet;
//
//        @Setup(Level.Invocation)
//        public void setup(){
//            this.dataSet = new int[]{2, 8, 2, 6, 4, 5, 6, 3, 1, 3};
//        }
//    }
//
//    @State(Scope.Thread)
//    public static class bigDataSetState{
//        final private int arraySize = 1000;
//        final private int intSize = 100;
//
//        public int[] dataSet = new int[arraySize];
//
//        @Setup(Level.Invocation)
//        public void setup(){
//            for (int i = 0; i < arraySize; i++){
//                this.dataSet[i] = (int) Math.round(Math.random() * this.intSize);
//            }
//        }
//    }
//
//
//    @Benchmark
//    public void testBubbleSortSmallDataSet(SortingBenchmarks.smallDataSetState state, Blackhole bh){
//        bh.consume(Sort.bubble(state.dataSet));
//    }
//
//    @Benchmark
//    public void testBubbleSortLargeDataSet(SortingBenchmarks.bigDataSetState state, Blackhole bh){
//        bh.consume(Sort.bubble(state.dataSet));
//    }
//
//    @Benchmark
//    public void testMergeSortSmallDataSet(SortingBenchmarks.smallDataSetState state, Blackhole bh){
//        bh.consume(Sort.merge(state.dataSet));
//    }
//
//    @Benchmark
//    public void testMergeSortLargeDataSet(SortingBenchmarks.bigDataSetState state, Blackhole bh){
//        bh.consume(Sort.merge(state.dataSet));
//    }
//}
