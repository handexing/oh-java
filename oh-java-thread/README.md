# oh-java-thread  :laughing: java多线程知识学习总结！


### 线程与进程

> 一个进程是一个独立(self contained)的运行环境，它可以被看作一个程序或者一个应用。而线程是在进程中执行的一个任务。线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务。不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间。别把它和栈内存搞混，每个线程都拥有单独的栈内存用来存储本地数据。

### 实现线程方法

- 继承Thread类
- 实现Runnable接口

> 实现runnable接口相比继承thread有如下优势：

- 可以避免由于 Java 的单继承特性而带来的局限；
- 增强程序的健壮性，代码能够被多个线程共享，代码与数据是独立的；
- 适合多个相同程序代码的线程区处理同一资源的情况。

### 线程的状态

- 创建（new）状态: 准备好了一个多线程的对象
- 就绪（runnable）状态: 调用了start()方法, 等待CPU进行调度
- 运行（running）状态: 执行run()方法
- 阻塞（blocked）状态: 暂时停止执行, 可能将资源交给其它线程使用
- 终止（dead）状态: 线程销毁

### 守护线程与线程阻塞

#### 守护线程

- User Thread(用户线程)
- Daemon Thread(守护线程)

> 用户线程即运行在前台的线程，而守护线程是运行在后台的线程。 守护线程作用是为其他前台线程的运行提供便利服务，而且仅在普通、非守护线程仍然运行时才需要，比如垃圾回收线程就是一个守护线程。当 VM 检测仅剩一个守护线程，而用户线程都已经退出运行时，VM就会退出，因为没有如果没有了被守护这，也就没有继续运行程序的必要了。如果有非守护线程仍然存活，VM 就不会退出。
守护线程并非只有虚拟机内部提供，用户在编写程序时也可以自己设置守护线程。用户可以用 Thread 的 setDaemon（true）方法设置当前线程为守护线程。

**注意：**
- setDaemon(true)必须在调用线程的 start()方法之前设置，否则会跑出 IllegalThreadStateException 异常。
- 在守护线程中产生的新线程也是守护线程。
- 不要认为所有的应用都可以分配给守护线程来进行服务，比如读写操作或者计算逻辑。


### Volatile 关键字

#### Volatile说明

> 在当前的 Java 内存模型下，线程可以把变量保存在本地内存（比如机器的寄存器）中，而不是直接在主存中进行读写。这就可能造成一个线程在主存中修改了一个变量的值，而另外一个线程还继续使用它在寄存器中的变量值的拷贝，造成数据的不一致。
Volatile 修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。










