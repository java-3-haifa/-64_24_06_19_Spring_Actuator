package com.sheygam.actuatorexample.monitoring;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class EventControllerMetric {
    private final Counter addEventCounter;
    private final Counter getAllEventsCounter;

    public EventControllerMetric(MeterRegistry registry) {
        getAllEventsCounter = registry.counter("getAllEventsCounter");
        addEventCounter = Counter.builder("events.add")
                .description("Add event endpoint counter")
                .register(registry);
    }

    public void handleAddEvent(){
        addEventCounter.increment();
    }

    public void handleGetEvents(){
        getAllEventsCounter.increment();
    }
}
