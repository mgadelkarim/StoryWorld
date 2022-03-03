package com.eg.story.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoriesDto {

	private Long id;

	private String storyTitle;

	private String storyName;

	private String storyCoverURL;

	private String storyBookURL;

	private String storyAudioURL;

	private String storyWriter;

	private int storyLevel;

	private String storyDescription;

	
	private List<StoryAssetsDto> storyAssets;
}
