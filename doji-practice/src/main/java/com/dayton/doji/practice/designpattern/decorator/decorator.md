1、装饰者模式(decorator pattern) 适用场景：  
(1) 扩展一个类的功能或给一个类添加附加职责。  
(2) 动态给一个对象添加功能，这些功能可以再动态地撤销。  

2、v2版本思路：
(1)先创建一个煎饼的抽象类 Battercake;
(2)创建一个基本煎饼类（基础套餐）BaseBattercake;
(3)再创建一个扩展套餐的抽象装饰者类 BattercakeDecotator;
(4)创建鸡蛋装饰者类 EggDecorator extends BattercakeDecotator;
(5)创建香肠装饰者类 SausageDecorator extends BattercakeDecotator;

3、装饰者模式优缺点  
优点：  
(1)是继承的有利补充，比继承灵魂，可以在不改变原有对象的情况下
动态地给一个对象扩展功能，即插即用。
(2)使用不同的装饰类及这些装饰类的排列组合，可以实现不同的效果。
(3)完全符合开闭原则。

缺点：  
(1)会出现更多的代码，更多的类，增加程序的复杂性。
(2)动态装饰时，多层装饰会更复杂。



