# Threading

## Overview
Threading is the execution of multiple `threads` within a single process.
Threads are smaller units of a process that share the same memory space and resources.
A process can contain multiple threads (multithreading), processes are isolated from one another, while threads within the same process share resources.

## Key Terms
| Term            | Description                                                                                                                                                                                                      |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Concurrency     | A system's ability to manage multiple processes in overlapping time period, so as to handle multiple activities at once, improving resource usage.                                                               |
| Multithreading  | A specific type of `threading` where `multiple threads` execute concurrently within the same process, allowing parallel executed or interleaved execution depending on system capabilities.                      |
| Process         | An independent unit of execution that runs in its own memory space. A process does not share memory space, unlike threads.                                                                                       |
| Race Condition  | A situation when multiple threads (or processes) access shared data or resources simuiltaneously, and the outcome depends on an unpredictable order of execution, leading to inconsistent or incorrect behavior. |
| Livelock        | A situation where two or more threads (or processes) continuously change their state in response to one another but cannot make progress.                                                                        |
| Deadlock        | A situation where two or more threads (or processes) are blocked forever, waiting on the other to release resources, thus creating a circular dependency and preventing any of the threads from proceeding.      |
| Starvation      | A situation where a thread (or process) is denied access to resources because other threads monopolise these resoruces, causing the starved thread to never get a chance to execute.                             |
| Synchronisation | Process of controlling access to shared resources in a multithreaded environment to prevent conflicts (eg: race conditions) by ensuring only one thread accesses a resource at a time.                           |

## Implementation
- Thread Class
- Runnable Interface