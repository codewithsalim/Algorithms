## Why and how Java is platform independent?

**1. Compiler and interpretor**

test.c (source code) --- compile ---> test.exe (machine code) 

Test.java(source code) --- compile ---> Test.class (Byte code) --- JVM --> Machine code   
JVM is interpretor.   
Java uses compiler as well as interpretor.

Platform dependence: test.c -- windows --> test.exe, cannot run on linux, mac etc.  
Platform independence: test.java -- compile --> test.class (byte code not machine code ) -- any platform --> JVM will take care

**2. Data types in JAVA** 

Byte | Short | Int | Long

Float | Double

Char | Boolean
