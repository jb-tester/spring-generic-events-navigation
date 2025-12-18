package com.mytests.spring.springeventsnavigation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class MessagePublisher {

    private final ApplicationEventPublisher eventPublisher;

   @Scheduled(fixedRate = 10000)
   public void scheduleEvent1() {
       sendEvent(1);
    }
    @Scheduled(fixedRate = 10000)
   public void scheduleEvent2() {
       sendEvent(2);
    }

    public void sendStringEvent() {

        // navigates to a specific (String-type) listener
        eventPublisher.publishEvent(new TypedMessageReceived<>("string message", "ID1"));

    }
    public void sendLongEvent() {

        // navigates to a specific (Long-type) listener
        eventPublisher.publishEvent(new TypedMessageReceived<>(2L, "ID2"));

    }
   public void sendEvent(int type) {

       // can't navigate to any typed listener, except Object. Navigates to raw-type listener
       // should navigate to all listeners
       eventPublisher.publishEvent(new TypedMessageReceived<>(getMessage(type), "ID1"));

   }



    private Object getMessage(int type) {
        if (type==1){
            return "Hello";
        }
        if(type==2){
            return 1L;
        }

        return 0;
    }
}