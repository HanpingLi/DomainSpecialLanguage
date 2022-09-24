package cn.haniel.dsl.eventcalendar.withoutbuilder;

import org.junit.jupiter.api.Test;

class CalendarWithoutBuilderTest {

    @Test
    public void addEventTest() {

        Calendar calendar = new Calendar();
        calendar.add("新建日历事件1")
                .at("成华大道")
                .on(2022, 9, 24)
                .from("10:00")
                .to("18:00");
        calendar.add("新建日历事件2")
                .at("ysu")
                .on(2022, 10, 1)
                .from("20:01")
                .to("21:00");
        System.out.println("");
    }

}