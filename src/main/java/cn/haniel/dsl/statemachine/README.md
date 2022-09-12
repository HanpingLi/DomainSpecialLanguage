## 定义

> 有限状态机（Finite-state machine,FSM），又称有限状态自动机，简称状态机，是表示**有限个状态**以及**在这些状态之间的转移**和**动作**等行为的数学模型

状态机模型可以将系统建模为一组显性的状态以及状态间的迁移。 只要需求能绘制出**状态迁移图**，状态机就能帮忙实现需求。

## 概念

状态机模型包含几个重要的概念，如：状态（state）、事件（event）、迁移（transition）、命令（command）/动作（action）、命令通道（commandChannel）、控制器 等
以下以 DSL 书中格兰特女士的控制为示例，解析以上几个概念
根据需求，手绘出大致的状态流程图如下：
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1774803/1662969314141-24f3fdd1-760b-4412-b963-1a7e15c1026a.png#clientId=u860dc3f6-a3c0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=460&id=u19a63d2d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1108&originWidth=1406&originalType=binary&ratio=1&rotation=0&showTitle=false&size=218207&status=done&style=shadow&taskId=u30113f88-85cf-457a-ab1f-63c69ab7e49&title=&width=584)
整理为标准的状态机框架类图
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1774803/1662970367222-e3dcffed-e085-41e9-b877-6bd48367760d.png#clientId=u1ae2adb4-115d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=378&id=u5d3f768f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=756&originWidth=1344&originalType=binary&ratio=1&rotation=0&showTitle=false&size=104970&status=done&style=shadow&taskId=uc8943923-2f7a-4843-b3c0-9bd52f37a47&title=&width=672)

#### State(状态)

广义上指的是某个对象在某一时刻的所有属性的值的集合。但在状态机模型中，通常指的是有限的几个，会**影响系统行为的状态**
状态类中通常包含以下属性

- 状态名
- 状态迁移表：表明在当前状态下，接收到什么事件，就迁移到什么状态
- 主动动作表：当进入当前状态后，需要主动执行的动作；通常存储的是命令，而非直接存储动作

#### State Machine(状态机)

状态机模型的核心，通常持有两个属性

- 起始状态
- 该状态机的所有可能的状态

#### Transition(迁移)

表达状态迁移这一行为
迁移类中通常包含以下属性

- 原状态
- 目标状态
- 触发器，也即事件

#### Event(事件)

事件就是执行某个操作，也可以看做外部系统的输入，用以触发改变状态

#### Command(命令)

迁移到某个状态后，该状态所主动要做的动作就是通过命令来间接表示，真正的 Action(动作) 需要通过 CommandChannel 来实现

#### Action(动作)

可以看做状态机对外部的输出。
本示例中，**动作**通过 CommandChannel 接收对应 Command 后的行为来表征

#### CommandChannel(命令通道)

接收Command，然后执行其对应的 Action
注意：CommandChannel 由控制器 Controller 持有

#### Controller(控制器)

控制器负责接收事件，指导状态机完成状态迁移 ？
控制器类通常包含以下属性

- 当前状态
- 状态机实例
- 命令通道

#### 总结

上面描述的状态机模型整体而言较为简单，基本能实现所有无嵌套状态的状态图。唯一需要用户注意的点为 CommandChannel 中 Action 的实现，需要结合自身项目实际情况实现。

## 状态机局限性

在 DSL 中，状态机只能对正则文法进行语法分析，无法处理任意嵌套的圆括号。

## 建模时机

当感觉行为像状态机，也即，行为被事件触发，从一个状态迁移到另一个状态时，就可以使用状态机模型进行表述。
状态机模型也不是一定要使用在软件中才有意义，在思考的时候借助状态机模型也是十分有益处的。