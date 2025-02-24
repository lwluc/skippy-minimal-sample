package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FooTest {

    private final Foo classUnderTest = new Foo();

    @ParameterizedTest
    @NullAndEmptySource
    void should_throw_if_illegal_argument(final String value) {
        assertThatThrownBy(() -> classUnderTest.doDemo(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Null or empty not allowed");
    }

    @ParameterizedTest
    @ValueSource(strings = { "081599", "testing_0815"})
    void should_return_true_if_contains_0815(final String value) {
        assertThat(classUnderTest.doDemo(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "01599", "testing_815"})
    void should_return_false_if_does_not_contains_0815(final String value) {
        assertThat(classUnderTest.doDemo(value)).isFalse();
    }
}