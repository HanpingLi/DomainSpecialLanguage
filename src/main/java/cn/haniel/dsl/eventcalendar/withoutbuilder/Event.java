package cn.haniel.dsl.eventcalendar.withoutbuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: lihanping
 * @description 事件
 * @date: 2022/9/24 2:54 PM
 */
public class Event {

    /**
     * 事件名称
     */
    private String name;

    /**
     * 事件发生的地址
     */
    private String location;

    /**
     * 事件发生的日期
     */
    private LocalDate date;

    /**
     * 事件的开始时间
     */
    private LocalTime startTime;

    /**
     * 事件的结束时间
     */
    private LocalTime endTime;


    public Event(String name) {
        this.name = name;
    }

    // ============= fluent api ===============
    public Event at(String location) {
        this.location = location;
        return this;
    }

    public Event on(Integer year, Integer month, Integer day) {
        this.date = LocalDate.of(year, month, day);
        return this;
    }

    public Event from(String startTimeStr) {
        this.startTime = LocalTime.parse(startTimeStr, DateTimeFormatter.ISO_LOCAL_TIME);
        return this;
    }

    public Event to(String endTimeStr) {
        this.endTime = LocalTime.parse(endTimeStr, DateTimeFormatter.ISO_LOCAL_TIME);
        return this;
    }

    // ============= command-query api ===============
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
