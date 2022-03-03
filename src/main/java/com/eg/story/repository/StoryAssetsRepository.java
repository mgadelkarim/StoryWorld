package com.eg.story.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import com.eg.story.entity.StoryAssetsEntity;

public interface StoryAssetsRepository extends CrudRepository<StoryAssetsEntity, Long> {

	@Cacheable("storyAssetsCache")
	List<StoryAssetsEntity> findByStoryIdOrderByPageNumber(Long storyId);

}
