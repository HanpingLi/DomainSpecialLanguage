package cn.haniel.dsl.statemachine;

import cn.haniel.dsl.statemachine.msg.Command;
import cn.haniel.dsl.statemachine.msg.Event;
import cn.haniel.dsl.statemachine.state.State;
import cn.haniel.dsl.statemachine.state.StateMachine;
import org.junit.jupiter.api.Test;


class ControllerTest {


    @Test
    void grantControllerTest() {
        Event doorClosed = new Event("doorClosed", "D1CL");
        Event drawerOpened = new Event("drawerOpened", "D2OP");
        Event lightOn = new Event("lightOn", "L1ON");
        Event doorOpened = new Event("doorOpened", "D1OP");
        Event panelClosed = new Event("panelClosed", "PNCL");

        Command unlockPanelCmd = new Command("unlockPanel", "PNUL");
        Command lockPanelCmd = new Command("lockPanel", "PNLK");
        Command lockDoorCmd = new Command("lockDoor", "D1LK");
        Command unlockDoorCmd = new Command("unlockDoor", "D1UL");

        State idle = new State("idle");
        State activeSate = new State("activeSate");
        State waitingForLightState = new State("waitingForLightState");
        State waitingForDrawerState = new State("waitingForDrawerState");
        State unlockedPanelState = new State("unlockedPanelState");

        idle.addTransition(doorClosed, activeSate); // 设定空闲状态的状态迁移表
        idle.addAction(unlockDoorCmd); // 设定空闲状态主动执行的动作
        idle.addAction(lockPanelCmd);

        activeSate.addTransition(drawerOpened, waitingForLightState);
        activeSate.addTransition(lightOn, waitingForDrawerState);

        waitingForLightState.addTransition(drawerOpened, unlockedPanelState);
        waitingForDrawerState.addTransition(lightOn, unlockedPanelState);

        unlockedPanelState.addTransition(panelClosed, idle);
        unlockedPanelState.addAction(unlockPanelCmd);
        unlockedPanelState.addAction(lockDoorCmd);


        StateMachine machine = new StateMachine(idle);
        machine.addResetEvents(doorOpened);
    }
}