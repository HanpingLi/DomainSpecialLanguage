package cn.haniel.dsl.statemachine.state;

import cn.haniel.dsl.statemachine.msg.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author: lihanping
 * @description 状态机
 * @date: 2022/9/12 9:46 AM
 */
public class StateMachine {

    /**
     * 状态机的起始状态
     */
    private State start;

    /**
     * 重置事件
     */
    private List<Event> resetEvents = new ArrayList<>();

    public StateMachine(State start) {
        this.start = start;
    }

    public State getStart() {
        return start;
    }

    /**
     * 从起始状态到达任意其他状态
     * @return
     */
    public Collection<State> getSates() {
        List<State> result = new ArrayList<>();
        collectStates(result, start);
        return result;
    }

    public void collectStates(Collection<State> result, State s) {
        if (result.contains(s)) {
            return;
        }

        result.add(s);
        for(State next: s.getAllTargets()) {
            collectStates(result, next);
        }
    }

    public void addResetEvents(Event... events) {
        this.resetEvents.addAll(Arrays.asList(events));
    }

    public boolean isResetEvent(String eventCode) {
        return resetEventCodes().contains(eventCode);
    }

    private List<String> resetEventCodes() {
        return resetEvents.stream().map(Event::getCode).toList();
    }
}
