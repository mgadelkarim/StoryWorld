package com.eg.story.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eg.story.entity.StoryEntity;

@Repository
public interface StoryRepository extends CrudRepository<StoryEntity, Long> {

	@Override
	@Cacheable("storiesCache")
	Iterable<StoryEntity> findAll();
}
