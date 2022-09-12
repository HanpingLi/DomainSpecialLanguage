package cn.haniel.dsl.statemachine;

import cn.haniel.dsl.statemachine.msg.CommandChannel;
import cn.haniel.dsl.statemachine.state.State;
import cn.haniel.dsl.statemachine.state.StateMachine;

/**
 * @author: lihanping
 * @description 控制器
 * @date: 2022/9/12 10:35 AM
 */
public class Controller {

    /**
     * 当前状态
     */
    private State currentState;

    /**
     * 状态机
     */
    private StateMachine machine;

    /**
     * 命令通道，用来接收被动事件和发送主动事件
     */
    private CommandChannel commandChannel;


    /**
     * 接收事件编码，如果事件可识别，则迁移到目标状态上
     *
     * @param eventCode 事件编码
     */
    public void handle(String eventCode) {
        if (currentState.hasTransition(eventCode)) {
            transitionTo(currentState.targetState(eventCode));
        } else if (machine.isResetEvent(eventCode)){
            transitionTo(machine.getStart());
        }
        // 忽略未知事件
    }

    /**
     * 执行状态迁移，同时执行迁移后状态的动作
     * @param target 目标状态
     */
    private void transitionTo(State target) {
        currentState = target;
        currentState.executeActions(commandChannel);
    }
}
