package cn.haniel.dsl.statemachine.state;

import cn.haniel.dsl.statemachine.msg.Event;

/**
 * @author: lihanping
 * @description 状态迁移
 * @date: 2022/9/12 9:38 AM
 */
public class Transition {

    private final State source;

    private final State target;

    private final Event trigger;

    public Transition(State source, Event trigger, State target) {
        this.source = source;
        this.target = target;
        this.trigger = trigger;
    }

    public State getSource() {
        return source;
    }

    public State getTarget() {
        return target;
    }

    public Event getTrigger() {
        return trigger;
    }

    public String getEventCode() {
        return this.trigger.getCode();
    }
}
