## 没有使用表达式构建器
1. fluent api 的命名风格和 command-query api 格格不入，但又都放在语义模型（Calendar 和 Event）上，导致理解上的困难
2. 当需要直接修改语义模型时，IDE 提示方法会返回所有的 fluent api 和 command-query api，令调用者困惑

## 使用表达式构建器
1. fluent api 专职于构建语义模型，被单独放置到了 builder 中。
2. command-query api 放置在语义模型中。
3. 构建器构造语义模型时，构建逻辑通过 fluent api 来表达，构建行为则是通过调用 command-query api 来实现
4. 语义模型上只有 command-query api，没有 fluent api 迷惑调用者

## 多个构建器的使用
1. 多个构建器使用时，总是构建成一棵树，父构建器调用子构建器构建对象，而后子构建器调用父构造器来生成一个新的自构造器，如此循环往复，保证用户能流畅使用 fluent api
2. 详情看 multibuilder 包中 CalendarBuilder 的 ```add()``` 和 EventBuilder 的 ```add()```，这两个方法保证了 fluent api 在两个父子构建器的切换
3. java 中的父子构建器，会优先推荐使用内部类来实现子构造器，不用手动维护上下关系