package com.eg.story.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.eg.story.dto.StoriesDto;
import com.eg.story.dto.StoryAssetsDto;
import com.eg.story.entity.StoryAssetsEntity;
import com.eg.story.entity.StoryEntity;
import com.eg.story.repository.StoryAssetsRepository;
import com.eg.story.repository.StoryRepository;
import com.eg.story.utils.ObjectMapperUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoryService {

	private final StoryRepository storyRepository;
	private final StoryAssetsRepository storyAssetsRepository;

	@Cacheable("storiesAssetsCach")
	public List<StoriesDto> getAllStories() {
		log.info("Start Get all stories");
		List<StoriesDto> storiesDto = new ArrayList<>();
//		StoryEntity story = StoryEntity.builder()
//				.storyName("MawqfAgeeb")
//				.storyTitle("موقف عحيب")
//				.storyBookURL("http://52.59.214.201/MawqfAgeeb/MawqfAgeeb.zip")
//				.storyCoverURL("http://52.59.214.201/MawqfAgeeb/MawqfAgeebCover.png")
//				.storyWriter("سارة محمد")
//				.storyLevel(1)
//				.storyDescription("قصة تحكي موقف عجيب")
//				.build();
//		
//		storyRepository.save(story);
//		
//		story = StoryEntity.builder()
//				.storyName("ArnbWHagar")
//				.storyTitle("الأرنب و الحجر")
//				.storyBookURL("http://52.59.214.201/ArnbWHagar/ArnbWHagar.zip")
//				.storyCoverURL("http://52.59.214.201/ArnbWHagar/ArnbWHagarCover.png")
//				.storyWriter("مالك اسلام")
//				.storyLevel(1)
//				.storyDescription("قصة تحكي الارنب والحجر")
//				.build();
//		
//		storyRepository.save(story);

//		List<StoryAssetsEntity>
		
		List<StoryEntity> stories = (List<StoryEntity>) storyRepository.findAll();

		if (stories != null) {
			storiesDto = ObjectMapperUtils.mapAll(stories, StoriesDto.class);

			storiesDto.forEach(story -> {

				List<StoryAssetsEntity> storyAssets = storyAssetsRepository.findByStoryIdOrderByPageNumber(story.getId());
				if (storyAssets != null)
					story.setStoryAssets(ObjectMapperUtils.mapAll(storyAssets, StoryAssetsDto.class));
			});
		}
		return storiesDto;
	}

	@CacheEvict(value = "storiesCache,storiesAssetsCach,storyAssetsCache", allEntries = true)
	public String evictCaching() {
		return "Cache Cleared";
	}
}
