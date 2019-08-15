package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*Task:
 *
 */
public class Country {
    private List<State> states = new ArrayList<>();

    public Country() {

    }

    public Country(List<State> states) {
        this.states = states;
    }

    public List<State> getStates() {
        return states;
    }

    public List<State> getState(String state) {

        List<State> selectedState = states
                .stream()
                .filter(st -> st.getName().equalsIgnoreCase(state))
                .collect(Collectors.toList());

        return selectedState;
    }


}
