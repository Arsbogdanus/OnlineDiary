package com.example.diary.repository;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository<Post> extends CrudRepository<Post, Long> {
}
