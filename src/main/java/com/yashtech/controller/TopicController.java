package com.yashtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yashtech.model.Topic;
import com.yashtech.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicServcie;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopic() {

		return topicServcie.getAllTopics();
	}
	
	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicServcie.getTopic(id);
	}
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		
		topicServcie.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public void updateTopic(@PathVariable("id") String id,@RequestBody Topic topic) {
		
		topicServcie.updateTopic(id, topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable("id") String id) {
		 topicServcie.deleteTopic(id);
	}
	
	
}
