package com.erik.JobPortal.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.erik.JobPortal.models.PostModel;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchRepository   {
	
	@Autowired
	MongoConverter converter;
	
	@Autowired
	MongoClient client;
	public List<PostModel> findByText(String str){
		
		List<PostModel> posts=new ArrayList<>();
		
		MongoDatabase database = client.getDatabase("JobPortal");
		MongoCollection<Document> collection = database.getCollection("JobPost");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("text", 
		    new Document("query", str)
		    .append("path", Arrays.asList("techs", "desc", "profile","exp")))), 
		    new Document("$sort", 
		    new Document("exp", 1L)), 
		    new Document("$limit", 5L)));
		
		result.forEach(doc->posts.add(converter.read(PostModel.class, doc)));
		return posts;
	}
}
