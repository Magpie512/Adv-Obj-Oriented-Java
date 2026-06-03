LogMonitor/
└── src/
    ├── LogListener.java        ← interface (the contract)
    ├── BaseLogger.java         ← abstract class (shared behaviour)
    ├── ConsoleLogger.java      ← concrete class (extends BaseLogger)
    ├── FileLogger.java         ← concrete class (extends BaseLogger)
    ├── LogPublisher.java       ← observer pattern (notifies all listeners)
    └── LogProcessor.java       ← stream pipeline (lambdas live here)