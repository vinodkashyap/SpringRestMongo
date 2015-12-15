package com.vinod;

import java.text.ParseException;

import org.bson.Document;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.FindIterable;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping({ "/schools" })
public class MongoController {
	@RequestMapping(value = { "/{school_id}" }, method = { RequestMethod.GET })
	public FindIterable<Document> get(@PathVariable("school_id") String schoolId) {
		return MongoDB.get(schoolId);
	}

	@RequestMapping(method = { RequestMethod.GET })
	public FindIterable<Document> getAll() {
		return MongoDB.getAll();
	}

	@RequestMapping(method = { RequestMethod.POST })
	public void insert() throws ParseException {
		MongoDB.insert();
	}

	@RequestMapping(value = { "/{school_id}" }, method = { RequestMethod.DELETE })
	public DeleteResult delete(@PathVariable("school_id") String schoolId) {
		return MongoDB.delete(schoolId);
	}

	@RequestMapping(value = { "/{school_id}" }, method = { RequestMethod.PUT })
	public UpdateResult update(@PathVariable("school_id") String schoolId) {
		return MongoDB.update(schoolId);
	}
}
