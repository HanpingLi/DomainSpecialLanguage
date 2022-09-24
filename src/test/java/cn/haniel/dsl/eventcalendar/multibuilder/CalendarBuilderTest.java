package cn.haniel.dsl.eventcalendar.multibuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarBuilderTest {

    @Test
    public void addEventTest() {

        CalendarBuilder calendarBuilder = new CalendarBuilder();
        calendarBuilder.add("新建日程1")
                .at("the queue road")
                .on(2022, 2,2)
                .from("11:11")
                .to("22:22")

                .add("新建日程2")
                .at("the queue road")
                .on(2012, 1,1)
                .from("03:10")
                .to("04:03");
        Calendar calendar = calendarBuilder.getCalendar();
        System.out.println("");
    }

}