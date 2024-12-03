# Threading

## Overview
Threading is the execution of multiple `threads` within a single process.
A `thread` is a sequence of instructions to be executed line by line that exits within a process (every process has at least one thread), and shares memory and resources with other threads.
A process can contain multiple threads (multithreading), processes are isolated from one another, while threads within the same process share resources.

## Key Terms
| Term            | Description                                                                                                                                                                                                      |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Concurrency     | A system's ability to manage multiple processes in overlapping time period, so as to handle multiple activities at once, improving resource usage.                                                               |
| Multithreading  | Concurrent execution of multiple `threads` within the same process, allowing parallel executed or interleaved execution depending on system capabilities.                                                        |
| Process         | A program that has its own memory and resources.                                                                                                                                                                 |
| Race Condition  | A situation when multiple threads (or processes) access shared data or resources simuiltaneously, and the outcome depends on an unpredictable order of execution, leading to inconsistent or incorrect behavior. |
| Livelock        | A situation where two or more threads (or processes) continuously change their state in response to one another but cannot make progress.                                                                        |
| Deadlock        | A situation where two or more threads (or processes) are blocked forever, waiting on the other to release resources, thus creating a circular dependency and preventing any of the threads from proceeding.      |
| Starvation      | A situation where a thread (or process) is denied access to resources because other threads monopolise these resoruces, causing the starved thread to never get a chance to execute.                             |
| Synchronisation | Process of controlling access to shared resources in a multithreaded environment to prevent conflicts (eg: race conditions) by ensuring only one thread accesses a resource at a time.                           |

## Benefits (Multithreading)
- Uses multiple cores.
- Improved responsiveness.
- Perform background tasks (eg: File uploads/downloads, email notifications, etc.).
- Deals with several tasks at once (eg: A process split into 2 threads runs faster than a single threaded process).

## Thread State
- Every application has at last 1 thread: `main thread`, whose set of instructions are code in the `main` method. This thread runs when the `main` method is invoked.
- Other threads are created and run concurrently with the `main thread`.
- Background system threads compete with these threads for `CPU time`.
- JVM's `thread scheduler` decides which thread to run.

| State      | Description                                                                                                                                                                      |
|------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| New        | A thread has been created.                                                                                                                                                       |
| Runnable   | A thread has entered the `Runnable` once the `start method` on a thread is called.                                                                                               |
| Running    | A thread is doing work.                                                                                                                                                          |
| Waiting    | A thread waits indefinitely for another thread to complete work.                                                                                                                 |
| Sleeping   | A thread is deliberately paused for a specified amount of time.                                                                                                                  |
| Blocked    | A thread is waiting for access to a `synchronized blocked or method that is currently used by anotheer thread. It is blocked until the lock it is waitinf for becomes available. |                                                                                 
| Terminated | A thread has completed work.                                                                                                                                                     |

## Implementation
- Thread Class (Extend thread class, override `run` method).
- Runnable Interface (implement the `run` method).
