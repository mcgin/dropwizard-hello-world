package com.example.helloworld.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Saying {
    private final long id;

    @Length(max = 3)
    private final String content;

    @JsonCreator
    public Saying(@JsonProperty("id") long id, @JsonProperty("content") String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Saying saying = (Saying) o;

        if (getId() != saying.getId()) return false;
        return !(getContent() != null ? !getContent().equals(saying.getContent()) : saying.getContent() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }
}