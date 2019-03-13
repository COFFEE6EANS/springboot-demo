# springboot-demo

### springboot-transaction
事务的传播特性
A()有事务注解，B()方法没有，在A中调用B的时候报错，事务回滚
在B中调用A的时候报错，事务无效
