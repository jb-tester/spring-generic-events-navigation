package com.mytests.spring.springeventsnavigation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class AnyMessageListener {

    // navigates to all publishers - ok
    @EventListener
    public void onApplicationEvent(TypedMessageReceived event) {
        System.out.println("**********************************");
        System.out.println("some event occurred! " + event.getRequest());
        System.out.println("**********************************");
    }
}