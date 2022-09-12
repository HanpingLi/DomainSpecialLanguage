package cn.haniel.dsl.statemachine.msg;

/**
 * @author: lihanping
 * @description 命令。位于某个状态时，主动将命令发送给命令通道，触发动作
 * @date: 2022/9/12 9:32 AM
 */
public class Command extends AbstractMsg {

    public Command(String name, String code) {
        super(name, code);
    }
}
