package com.example;

class Foo {

    public boolean doDemo(final String sample) {
        if (sample == null || sample.isEmpty()) {
            throw new IllegalArgumentException("Null or empty not allowed");
        }

        return sample.contains("0815");
    }
}
