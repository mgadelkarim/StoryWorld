package com.eg.story.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_STORY")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false)
	private Long id;

	@Column(name = "STORY_TITLE", nullable = false)
	private String storyTitle;

	@Column(name = "STORY_NAME", nullable = false)
	private String storyName;

	@Column(name = "STORY_COVER_URL", nullable = false)
	private String storyCoverURL;

	@Column(name = "STORY_BOOK_URL", nullable = false)
	private String storyBookURL;

	@Column(name = "STORY_AUDIO_URL")
	private String storyAudioURL;

	@Column(name = "STORY_WRITER", nullable = false)
	private String storyWriter;

	@Column(name = "STORY_LEVEL")
	private int storyLevel;

	@Column(name = "STORY_DESCRIPTION", nullable = false)
	private String storyDescription;

	@Column(name = "CREATED_AT", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "UPDATED_AT")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
