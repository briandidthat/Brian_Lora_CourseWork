package com.trilogyed.trilogythesaurus.model;

import java.util.Objects;

public class Definition {
    private int id;
    private String term;
    private int definition;


    public int getId() {
        return id;
    }

    public String getTerm() {
        return term;
    }

    public int getDefinition() {
        return definition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setDefinition(int definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return id == that.id &&
                definition == that.definition &&
                term.equals(that.term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, term, definition);
    }

    @Override
    public String toString() {
        return "Definition{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", definition=" + definition +
                '}';
    }
}
