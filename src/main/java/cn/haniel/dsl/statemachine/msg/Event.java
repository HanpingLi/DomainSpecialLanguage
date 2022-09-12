package cn.haniel.dsl.statemachine.msg;

/**
 * @author: lihanping
 * @description 事件，用以触发改变状态
 * @date: 2022/9/12 9:33 AM
 */
public class Event extends AbstractMsg {

    public Event(String name, String code) {
        super(name, code);
    }
}
