package com.mytests.spring.springeventsnavigation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class LongMessageListener {

    // navigates to sendLongEvent() publisher that has the explicit Long-type parameter,
    // but not to sendEvent() one that gets parameter from getMessage():Object method call
    // should navigate to both publishers
    @EventListener
    public void onApplicationEvent(TypedMessageReceived<Long> event) {
        System.out.println("**********************************");
        System.out.println("long-type event occurred! " + event.getRequest());
        System.out.println("**********************************");
    }
}