package concurrency.java;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * 并发的一些注解
 *
 * 域注解和方法注解都是用@GuardedBy( lock )来标识。里面的Lock是告诉维护者：这个状态变量，这个方法被哪个锁保护着。这样可以强烈的提示类的维护者注意这里。

 有以下几种使用形式：

 1、@GuardedBy( "this" ) 受对象内部锁保护
 2、@GuardedBy( "fieldName" ) 受与fieldName引用相关联的锁 保护。
 3、@GuardedBy( "ClassName.fieldName" ) 受 一个类的静态field的锁 保存。
 4、@GuardedBy( "methodName()" ) 锁对象是 methodName() 方法的返值，受这个锁保护。
 5、@GuardedBy( "ClassName.class" ) 受 ClassName类的直接锁对象保护。而不是这个类的某个实例的锁对象。
 *
 * Created by cc on 16/3/20.
 */
// @NotThreadSafe
@ThreadSafe
public class Annotations {

    @GuardedBy("this") private int x, y;
}
