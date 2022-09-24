package cn.haniel.dsl.eventcalendar.withbuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lihanping
 * @description 事件日历
 * @date: 2022/9/24 3:42 PM
 */
public class Calendar {

    /**
     * 日历中所有的事件
     */
    private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }
}
