package com.example.demo;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by patrik.mihalcin on 26.5.2017.
 */
@Service
@RequiredArgsConstructor
public class Initializer {

    private final PostRepository posts;

    @EventListener
    public void init(ApplicationReadyEvent event) {

        if (posts.count() > 0) {
            return;
        }

        Post post1 = new Post("JPA with Hibernate");
        Post post2 = new Post("Native Hibernate");

        Tag tag1 = new Tag("Java");
        Tag tag2 = new Tag("Hibernate");

        post1.addTag(tag1);
        post1.addTag(tag2);
        post2.addTag(tag1);

        posts.save(Arrays.asList(post1, post2));
    }
}