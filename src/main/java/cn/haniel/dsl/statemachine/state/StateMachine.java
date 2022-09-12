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
     * 状态机的所有状态
     */
    private List<State> allStates;

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

    public Collection<State> getAllSates() {
        List<State> result = new ArrayList<>();
        collectStates(result, start);
        return result;
    }

    public void collectStates(Collection<State> result, State s) {
        if (result.contains(s)) {
            return;
        }

        result.add(s);
        for (State next : s.getAllTargets()) {
            collectStates(result, next);
        }
    }

    // ================= 重置处理

    /**
     * 设定重置事件
     *
     * @param events 重置事件列表
     */
    public void addResetEvents(Event... events) {
        this.resetEvents.addAll(Arrays.asList(events));
    }

    /**
     * 输入一个事件编码，判断是否为该状态机的重置事件
     *
     * @param eventCode 待判断的事件编码
     * @return 结果
     */
    public boolean isResetEvent(String eventCode) {
        return resetEvents.stream()
                .map(Event::getCode)
                .anyMatch(resetEventCode -> resetEventCode.equals(eventCode));
    }
}
