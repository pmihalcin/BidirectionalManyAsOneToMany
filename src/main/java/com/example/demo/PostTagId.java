package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Getter;

/**
 * Created by patrik.mihalcin on 26.5.2017.
 */
@Getter
@Embeddable
public class PostTagId implements Serializable {

    private Long postId;

    private Long tagId;

    public PostTagId() {
    }

    public PostTagId(Long postId, Long tagId) {
        this.postId = postId;
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTagId that = (PostTagId) o;
        return Objects.equals(postId, that.postId) &&
                Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, tagId);
    }

}
