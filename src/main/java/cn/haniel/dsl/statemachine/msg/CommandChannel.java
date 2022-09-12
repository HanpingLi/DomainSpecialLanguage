package cn.haniel.dsl.statemachine.msg;

/**
 * @author: lihanping
 * @description 命令通道。用来接收被动事件和发送主动事件，被控制器所持有
 * @date: 2022/9/12 10:55 AM
 */
public class CommandChannel {

    public void send(String eventCode) {
        System.out.println("执行事件：" + eventCode);
    }
}
