package com.eg.story.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoryAssetsDto {

	private Long storyId;

	private String pageNumber;

	private String imageURL;

	private String soundUrl;
}
