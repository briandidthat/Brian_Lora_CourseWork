package com.trilogyed.trilogythesaurus.model;

import java.util.Objects;

public class Definition {
    private int id;
    private String term;
    private String definition;

    public int getId() {
        return id;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return id == that.id &&
                term.equals(that.term) &&
                definition.equals(that.definition);
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
                ", definition='" + definition + '\'' +
                '}';
    }
}
