package com.sheygam.actuatorexample.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface EventRepository {
    boolean add(EventEntity event);
    List<EventEntity> getAll();
}
