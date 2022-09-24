package cn.haniel.dsl.eventcalendar.withbuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: lihanping
 * @description 构建事件日历的表达式构造器
 * @date: 2022/9/24 3:44 PM
 */
public class CalendarBuilder {

    /**
     * 每个日历表达式实例对应一个日历实例
     */
    private final Calendar calendar = new Calendar();

    public Calendar getCalendar() {
        return this.calendar;
    }

    /**
     * 默认最后一个元素就是当前事件，这种方式不好
     *
     * @return 当前事件
     */
    public Event getCurrentEvent() {
        return this.calendar.getEvents().get(calendar.getEvents().size() - 1);
    }

    // =====================fluent api=====================

    public CalendarBuilder add(String eventName) {
        Event event = new Event(eventName);
        calendar.getEvents().add(event);
        return this;
    }

    public CalendarBuilder at(String location) {
        this.getCurrentEvent().setLocation(location);
        return this;
    }

    public CalendarBuilder on(Integer year, Integer month, Integer day) {
        this.getCurrentEvent().setDate(LocalDate.of(year, month, day));
        return this;
    }

    public CalendarBuilder from(String startTimeStr) {
        this.getCurrentEvent().setStartTime(LocalTime.parse(startTimeStr, DateTimeFormatter.ISO_LOCAL_TIME));
        return this;
    }

    public CalendarBuilder to(String endTimeStr) {
        this.getCurrentEvent().setEndTime(LocalTime.parse(endTimeStr, DateTimeFormatter.ISO_LOCAL_TIME));
        return this;
    }
}
