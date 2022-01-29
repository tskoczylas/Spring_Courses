package com.onlineshop.toms.entity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OrderStatusTest {

    @Test
    void geNextOrderShuldReturnInProgressmWhenIsNew() {
        //given
        OrderStatus orderStatus = OrderStatus.NEW;
        //then
        assertThat(OrderStatus.geNextOrder(orderStatus),is(equalTo(OrderStatus.IN_PROGRESS)));
    }
    @Test
    void geNextOrderShuldReturnCompletemWhenIsInProgress() {
        //given
        OrderStatus orderStatus = OrderStatus.IN_PROGRESS;
        //then
        assertThat(OrderStatus.geNextOrder(orderStatus),is(equalTo(OrderStatus.COMPLETE)));
    }
    @Test
    void geNextOrderShuldThrownIllegalArgumentExceptionWhenIsComplete() {
        //given
        OrderStatus orderStatus = OrderStatus.COMPLETE;
        //then
        assertThrows(IllegalArgumentException.class,()->OrderStatus.geNextOrder(orderStatus));
    }




}