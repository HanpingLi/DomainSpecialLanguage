package cn.haniel.dsl.statemachine.msg;

/**
 * @author: lihanping
 * @description 消息超类
 * @date: 2022/9/12 9:30 AM
 */
public class AbstractMsg {

    /**
     * 消息名称
     */
    private String name;

    /**
     * 消息编码
     */
    private String code;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public AbstractMsg(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
