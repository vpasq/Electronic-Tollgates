![Readme image](readme.png)

# ElectronicTollGates ([UML Diagram](https://github.com/vpasq/Electronic-Tollgates/blob/master/ETC_UML.pdf)) 
ElectronicTollCollection is a Java Maven project simulation of an Electronic Toll Collection 
System. Customers are assigned to random vehicles and then driven through tollgates on random 
highways. Each customer can own multiple vehicles, which is randomly determined at runtime. 
The Visitor Pattern is used to calculate individual toll costs and then print the invoices to 
system.out. The number of customers, and the number of months to simulate, can be easily changed at 
the beginning, or even during, the simulation.

Note:  
I wanted to show the invoices displayed to the screen. But breaking them down to monthly
invoices for each customer makes the output way too long, so I am just showing the totals for 
the number of months selected. 

A complete list of design patterns used is as follows:
 
- Visitor Pattern
- Factory Pattern
- Strategy Pattern 
- Singleton Pattern

# Visitor Pattern

The Visitor Pattern is used to calculate toll costs for each customer. A TollCostVisitor visits 
the EtcSystem, calculates costs, and then displays the individual invoices to System.out. 

# Factory Method

The Factory Method is used to create a variety of random vehicles. It is used 
in combination with the Strategy Pattern to allow a variety of vehicles to be randomly
created for the simulation.

# Strategy Pattern

The Strategy Pattern is used to encapsulate a family of vehicle algorithms. By exploiting 
polymorphism, the EtcSystem simulation can be initialized with random vehicle types. In addition, 
the Strategy Pattern would allow customer vehicles to be dynamically changed during the simulation 
if so desired.

# Singleton Pattern

The Singleton Pattern is used to create a single unique instance of the EtcSystem. 
Lazy instantiation is used to create an instance if it does not exist. The getInstance() method
is defined as a synchronized static method to fix the multithreading issue by forcing every thread 
to wait its turn before it can enter the method. Therefore, no two threads may enter the method 
at the same time.

# Install and run jUnit tests
```bash
1. Clone this repository
2. mvn clean compile test

```

# Version
1.0.0

# License

The MIT License (MIT)

Copyright (c) 2019 Vincent Pasquariello

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


