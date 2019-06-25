package com.sheygam.actuatorexample.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class EventDto {
    public String title;
    public String description;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    public LocalDateTime date;
    public String authorEmail;
}
