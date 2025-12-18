package com.mytests.spring.springeventsnavigation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class ObjectMessageListener {

    // navigates to sendEvent(int type) publisher (detected by the type of the event parameter that is getMessage():Object)
    @EventListener
    public void onApplicationEvent(TypedMessageReceived<Object> event) {
        System.out.println("**********************************");
        System.out.println("Object event occurred! " + event.getRequest());
        System.out.println("**********************************");
    }
}