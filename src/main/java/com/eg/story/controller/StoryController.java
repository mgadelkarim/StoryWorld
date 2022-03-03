package com.eg.story.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.story.service.StoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "v1")
@Slf4j
public class StoryController {

	private final String serviceName = this.getClass().getName();

	private final StoryService storyService;

	@GetMapping("/stories")
	public ResponseEntity<?> getStories() {
		log.info(serviceName + " Get Content By Service Identifier Request :- ");
		return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);

	}

	@PostMapping("/story/{id}")
	public ResponseEntity<?> getStoryById() {
		log.info(serviceName + " Get Content By Service Identifier Request :- ");
		return null;
//				new ResponseEntity<>(
//				contentManagmentService.getContentByServiceIdentifier(lng, req.getServiceIdentifier()), HttpStatus.OK);

	}
	
	@GetMapping("/clear-cache")
	public ResponseEntity<?> clearCache() {
		log.info(serviceName + " Get Content By Service Identifier Request :- ");
		return new ResponseEntity<>(storyService.evictCaching(), HttpStatus.OK);

	}
}
