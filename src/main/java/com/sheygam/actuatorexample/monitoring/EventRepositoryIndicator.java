package com.sheygam.actuatorexample.monitoring;

import com.sheygam.actuatorexample.repository.EventRepository;
import com.sheygam.actuatorexample.repository.EventRepositoryImpl;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventRepositoryIndicator implements HealthIndicator {
    private ApplicationContext context;

    public EventRepositoryIndicator(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Health health() {
        EventRepository repository = context.getBean(EventRepository.class);
        if(repository == null){
            return Health.down().withDetail("Error","EventRepository is down").build();
        }
        return Health.up().build();
    }
}
