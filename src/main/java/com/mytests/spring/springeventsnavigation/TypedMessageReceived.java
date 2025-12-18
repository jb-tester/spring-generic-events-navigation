package com.mytests.spring.springeventsnavigation;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;


public class TypedMessageReceived<T> extends ApplicationEvent implements ResolvableTypeProvider {
    @Getter
    private final String requestMessageId;
    @Getter
    private final T request;

    public TypedMessageReceived(T request, String messageId) {
        super(request);
        this.requestMessageId = messageId;
        this.request = request;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(getSource()));
    }


}