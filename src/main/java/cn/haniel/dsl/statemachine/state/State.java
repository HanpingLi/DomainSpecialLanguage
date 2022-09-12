package cn.haniel.dsl.statemachine.state;

import cn.haniel.dsl.statemachine.msg.Command;
import cn.haniel.dsl.statemachine.msg.CommandChannel;
import cn.haniel.dsl.statemachine.msg.Event;

import java.util.*;

/**
 * @author: lihanping
 * @description 状态
 * @date: 2022/9/12 9:34 AM
 */
public class State {

    /**
     * 状态名称
     */
    private String name;

    /**
     * 状态迁移表
     * 遇到特定事件时，当前状态应该迁移的目标状态
     * code：Transition
     */
    private Map<String, Transition> transitions = new HashMap<>();

    /**
     * 主动事件表(进入该状态以后自动调用)
     */
    private List<Command> actions = new ArrayList<>();

    public State(String name) {
        this.name = name;
    }

    public void addTransition(Event event, State targetState) {
        assert null != targetState;
        this.transitions.put(event.getCode(), new Transition(this, event, targetState));
    }

    public void addAction(Command command) {
        this.actions.add(command);
    }


    public Collection<State> getAllTargets() {
        return transitions.values().stream()
                .map(Transition::getTarget)
                .toList();
    }

    /**
     * 判断给定的事件编码是否注册在该状态上的事件
     *
     * @param eventCode 事件编码
     * @return boolean
     */
    public boolean hasTransition(String eventCode) {
        return transitions.containsKey(eventCode);
    }

    public State targetState(String eventCode) {
        return transitions.get(eventCode).getTarget();
    }

    /**
     * 执行当前状态的动作
     *
     * @param commandChannel 命令通道
     */
    public void executeActions(CommandChannel commandChannel) {
        actions.forEach(command -> commandChannel.send(command.getCode()));
    }
}
