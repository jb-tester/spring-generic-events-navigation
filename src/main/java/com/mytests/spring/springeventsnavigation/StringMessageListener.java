package com.mytests.spring.springeventsnavigation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class StringMessageListener {

    // navigates to sendStringEvent() publisher that has the explicit String-type parameter,
    // but not to sendEvent() one that gets parameter from getMessage():Object method call
    @EventListener
    public void onApplicationEvent(TypedMessageReceived<String> event) {
        System.out.println("**********************************");
        System.out.println("String-type event occurred! " + event.getRequest());
        System.out.println("**********************************");
    }
}