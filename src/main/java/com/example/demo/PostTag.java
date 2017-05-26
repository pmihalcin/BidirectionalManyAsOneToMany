package com.example.demo;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by patrik.mihalcin on 26.5.2017.
 */
@Getter
@Entity
public class PostTag {

    @EmbeddedId
    private PostTagId id;

    @Setter
    @ManyToOne
    @MapsId("postId")
    private Post post;

    @Setter
    @ManyToOne
    @MapsId("tagId")
    private Tag tag;

    public PostTag() {
    }

    public PostTag(Post post, Tag tag) {
        this.post = post;
        this.tag = tag;
        this.id = new PostTagId(post.getId(), tag.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTag that = (PostTag) o;
        return Objects.equals(post, that.post) &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post, tag);
    }
}
