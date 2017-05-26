package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by patrik.mihalcin on 26.5.2017.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
