// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.lib;

import java.util.*;

/** Class for creating states in each subsystem's state machine */
public class State {

    public void build() {}

    // list to hold all the transitions between states
    public List<Transition> transitions = new ArrayList<Transition>();

    // variable to hold the state machine's name
    public String state_machine_name = "";

    // method to add transitions to a state by passing in a Transition object
    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    // get all the transitions for a state
    public List<Transition> getTransitions() {
        return transitions;
    }

    public void init() {}

    public void execute() {}

    public void exit() {}

    // this method is called when initializing a state and it will also print statement
    public void init_private() {
        System.out.println(state_machine_name + ": entering state " + this.getClass().getName());
        init();
    }

    // this method is called when executing a state
    public void execute_private() {
        execute();
    }

    // this method is called when exiting a state
    public void exit_private() {
        System.out.println(state_machine_name + ": exiting state " + this.getClass().getName());
        exit();
    }
}
