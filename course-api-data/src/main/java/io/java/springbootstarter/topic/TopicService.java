package io.java.springbootstarter.topic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepo topicRepo;
	

	public List<Topic> getAllTopics()
	{
		List<Topic> topics=new ArrayList<>();
		topicRepo.findAll()
		.forEach(topics::add);
				return topics;
	}
	
      //return topics.stream().filter(t --> t.getId().equals(id)).findFirst().get();   
		public Topic getTopic(String id){
			  
			return topicRepo.findOne(id);
				}
		public void addTopic(Topic topic)
		{
			topicRepo.save(topic);
			//topics.add(topic);
		}
		public void updateTopic(String id,Topic topic)
		{
			topicRepo.save(topic);
			
				
		}
		public void deleteTopic(String id)
		{
			
			topicRepo.delete(id);

		}
}
