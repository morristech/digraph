package com.uber.di.sample;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class Sample {

    public static void main(String[] args) {
        O o = DaggerSample_A.builder().m(new M()).build().o();
        System.out.println(o);
    }

    static class O {
        private final String s1;
        private final String s2;

        public O(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public String toString() {
            return s1 + ":" + s2;
        }
    }

    @Module
    static class M {

        static int i = 0;

        @Provides
        String s() {
            return String.valueOf(i++);
        }

        @Provides
        O i(String a, String b) {
            return new O(a, b);
        }
    }

    @Component(modules = M.class)
    interface A {

        O o();
    }
}
