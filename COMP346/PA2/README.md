# COMP346: Operating Systems

## Programming Assignment 2:

## Description:
This is a continuous of programming assignment 1 with some modification.
The program was modified to stimulate the "inconsistent" of multithreading by letting `Server` thread sleep while it is processing, give a chance for the other thread to interrupt, and cause invalid/incorrect result at the end.
```
Note:
 All the output files generated during the project were placed inside folder [output](./output)
 The program does not generate any output to the terminal. It directs output to a dedicated file inside output folder.
```

The project was divided into 2 phases:

### Phase 1: Synchronize to protect critical sessions:
+ At the beginning, the output is inconsistent with many incorrect balance of various accounts such as account 60520. The output file was named in the format of `output-unsynchronized[#number].txt` 
+ Implementing Synchronize resolved the inconsistent problem. Synchronize method in Java is arguably equivalent to the concept of `Monitor`.
+ Implementing Synchronize methods would be inefficient since multi-threading cannot invoke the method when a synchronize method is processing. Instead, synchronized statements were implemented to ensure consistent output as well efficiency. 
+ The consistent result was recorded and redirected to output folder in format of `output-synchronized[#number].txt`

### Phase 2: Utilize semaphores to enhance the performance:
+ The problem is heavily inspired by the famed [*Producer-consumer problem*](https://en.wikipedia.org/wiki/Producer%E2%80%93consumer_problem) (or [*Bounded buffer problem*](http://www.it.uu.se/education/course/homepage/os/vt18/module-4/bounded-buffer/)) with the exception of 2 ends. Therefore, the program requires **6 semaphores** (2 of them are mutexs) to lock and prevent interruptions during the process.
+ In each turn, there will be 2 semaphores involving to make sure Server and Client only operate when there is resource inside buffer, ultimately prevents `null pointer exception`. In addition, there is a mutex for each turn to safe guard the buffer(packet) from being accessed by 2 threads at the same time.
+ The output was redirected and formated as `output-semaphores[#number]`.

### Bonus:
+ The `DEBUG` tag was included to make `DEBUG` process easier as it tells what is being processed at a point; however it can be removed by running the program `removeDEBUG.java` inside `src`. Change the directory to change the target file to remove `DEBUG` tag





