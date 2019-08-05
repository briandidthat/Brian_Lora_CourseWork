package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Task:
 *
 */
public class ClassmatesList {
    private List<Classmate> classmates = new ArrayList<>();

    public void add(Classmate classmate) {
        this.classmates.add(classmate);
    }

    public Classmate get(int index) {
        return this.classmates.get(index);
    }

    public List getAll() {
        return this.classmates;
    }
}
