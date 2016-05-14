package com.company;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;



public class TaskCollection implements Iterable<Task> {
    private List<Task> tasks = new ArrayList<>();


    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

    public Task get(int index){
        return tasks.get(index);
    }

    public void remove(int index){
        tasks.remove(index);

    }

    public void sort() {
        Collections.sort(tasks);
    }

}
