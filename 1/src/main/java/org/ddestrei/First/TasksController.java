package org.ddestrei.First;

import org.ddestrei.First.tasks.fifth.Fifth;
import org.ddestrei.First.tasks.first.First;
import org.ddestrei.First.tasks.fourth.Fourth;
import org.ddestrei.First.tasks.second.Second;
import org.ddestrei.First.tasks.third.Third;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService=tasksService;
    }
    @GetMapping("/first")
    public Collection<First> first(){
       return tasksService.firstTask();
    }

    @GetMapping("/second")
    public Collection<Second> second(){
        return tasksService.secondTask();
    }

    @GetMapping("/third")
    public Collection<Third> third(){
        return tasksService.thirdTask();
    }

    @GetMapping("/fourth")
    public Collection<Fourth> fourth(){
        return tasksService.fourthTask();
    }
    @GetMapping("/fifth")
    public Collection<Fifth> fifth(){
        return tasksService.fifthTask();
    }
}
