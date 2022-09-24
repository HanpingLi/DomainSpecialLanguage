package cn.haniel.dsl.eventcalendar.multibuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 两层的构建器，通常子构建器会通过内部类的方式来实现
 *
 * @author: lihanping
 * @description 日历构建器
 * @date: 2022/9/24 5:29 PM
 */
public class CalendarBuilder {

    private List<EventBuilder> eventBuilders = new ArrayList<>();

    public EventBuilder add(String eventName) {
        EventBuilder childBuilder = new EventBuilder();
        eventBuilders.add(childBuilder);

        childBuilder.setName(eventName);
        return childBuilder;
    }
    
    public Calendar getCalendar() {
        Calendar calendar = new Calendar();
        List<Event> events = eventBuilders.stream()
                .map(EventBuilder::getEvent)
                .toList();
        calendar.setEvents(events);
        return calendar;
    }


    public class EventBuilder {

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


        public EventBuilder() {
        }

        public Event getEvent() {
            return new Event(name, location, date, startTime, endTime);
        }

        public EventBuilder at(String location) {
            this.location = location;
            return this;
        }

        public EventBuilder on(Integer year, Integer month, Integer day) {
            this.date = LocalDate.of(year, month, day);
            return this;
        }

        public EventBuilder from(String startTimeStr) {
            this.startTime = LocalTime.parse(startTimeStr, DateTimeFormatter.ISO_LOCAL_TIME);
            return this;
        }

        public EventBuilder to(String endTimeStr) {
            this.endTime = LocalTime.parse(endTimeStr, DateTimeFormatter.ISO_LOCAL_TIME);
            return this;
        }

        public EventBuilder add(String evenName) {
            return CalendarBuilder.this.add(evenName);
        }


        // ========================================

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
}
