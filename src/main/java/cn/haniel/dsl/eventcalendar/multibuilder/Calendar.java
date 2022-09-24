package cn.haniel.dsl.eventcalendar.multibuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lihanping
 * @description 事件日历
 * @date: 2022/9/24 4:58 PM
 */
public class Calendar {

    private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
