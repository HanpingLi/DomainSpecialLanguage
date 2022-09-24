package cn.haniel.dsl.eventcalendar.withoutbuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lihanping
 * @description 事件日历
 * @date: 2022/9/24 2:53 PM
 */
public class Calendar {

    /**
     * 日历中的所有事件
     */
    private List<Event> events = new ArrayList<>();

    /**
     * 构建开始的入口
     * 生成一个事件对象并返回，后续的构建动作都是返回这个事件对象
     *
     * @param eventName 事件名称
     * @return 事件对象
     */
    public Event add(String eventName) {
        Event event = new Event(eventName);
        events.add(event);
        return event;
    }
}
