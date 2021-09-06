**Thread Definition**
Every JAVA program has one main thread
Thread is an independent path of code execution
Many threads can run concurrently 
Each thread executes a runnable object
Asynchorouns task

JVM gives private stack for each thread
Java supports thread through java.lang.Thread class
and java.lang.runnable interface

Daemon threads dont stop JVM from ending
By default Non-daemon thread

**State** 
New Thread() --start()--> Runnable --run()--> Running --wait()--> Waiting --notify()--> --- Dead

**Create a thread**
1. Declare a new class as sub class of Thread
  - This class must override run method
  - An instance of this class can be started

2. Implement Runnable interface


