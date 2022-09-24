package cn.haniel.dsl.eventcalendar.withbuilder;

import org.junit.jupiter.api.Test;

class CalendarBuilderTest {

    @Test
    public void testBuildCalendar() {

        CalendarBuilder calendarBuilder = new CalendarBuilder();

        calendarBuilder.add("新建行程")
                .at("北京东路")
                .on(2014, 8, 8)
                .from("11:02")
                .to("14:11")

                .add("新建另一个行程")
                .at("内蒙古")
                .on(2200, 9, 19)
                .from("21:32")
                .to("22:01");

        Calendar calendar = calendarBuilder.getCalendar();
        System.out.println("");
    }

}