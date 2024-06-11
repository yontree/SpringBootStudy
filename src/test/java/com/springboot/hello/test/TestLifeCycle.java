package com.springboot.hello.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {
    
    //테스트 시작전 딱 한번만 실행
    @BeforeAll
    static void beforeAll() {
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();
    }

    //모든 테스트가 끝난 후 한번만 실행
    @AfterAll
    static void afterall() {
        System.out.println("## AfterAll Annotation 호출 ##");
        System.out.println();
    }

    //테스트별로 테스트 시작 전에 한번만 실행
    @BeforeEach
    void beforeEach() {
        System.out.println("## BeforeEach Annotation 호출 ##");
        System.out.println();
    }
    
    //테스트별로 테스트가 끝나고 한번만 실행
    @AfterEach
    void afterEach() {
        System.out.println("## AfterEach Annotation 호출 ##");
        System.out.println();
    }

    @Test
    void test1() {
        System.out.println("## test1 시작 ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2!!")
    void test2() {
        System.out.println("## test2 시작 ##");
        System.out.println();
    }
    
    @Test
    @Disabled
    void test3() {
        System.out.println("## test3 시작 ##");
        System.out.println();
    }

}
