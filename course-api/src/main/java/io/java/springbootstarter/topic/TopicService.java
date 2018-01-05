package io.java.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("spring","spring framework","spring frmework description"),
			new Topic("java","core java","core java description"),
			new Topic("js","javascript","javascript description")
			));
	public List<Topic> getAllTopics()
	{
		return topics;
	}
	
      //return topics.stream().filter(t --> t.getId().equals(id)).findFirst().get();   
		public Topic getTopic(String id){
			  
			  Topic tp = new Topic();
			  for(int i=0; i<topics.size(); i++){
			   Topic t = topics.get(i);
			   if(t.getId().equals(id)){
			    tp = topics.get(i);
			   }  
			  } return tp;	 
	}
		public void addTopic(Topic topic)
		{
			topics.add(topic);
		}
		public void updateTopic(String id,Topic topic)
		{
			for(int i=0;i<topics.size();i++)
			{
				Topic t=topics.get(i);
				if(t.getId().equals(id))
				{
					topics.set(i,topic);
					return;
				}
			}
				
		}
		public void deleteTopic(String id)
		{
			//return topics.removeIf(t -> t.getId().equals(id));
			Topic tp = new Topic();
			  for(int i=0; i<topics.size(); i++){
			   Topic t = topics.get(i);
			   if(t.getId().equals(id)){
			    tp = topics.remove(i);
			   }  
			  } return ;	 

		}
}
