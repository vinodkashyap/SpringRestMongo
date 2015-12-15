package com.vinod;

import static java.util.Arrays.asList;

import java.text.ParseException;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Component
public class MongoDB {
	static MongoClient mongoClient = new MongoClient();
	static MongoDatabase db = mongoClient.getDatabase("test");

	public static FindIterable<Document> get(String schoolId) {
		return db.getCollection("schools").find(new Document("school_id", schoolId));
	}

	public static FindIterable<Document> getAll() {
		return db.getCollection("schools").find();
	}

	public static void insert() throws ParseException {
		db.getCollection("schools")
				.insertMany(asList(
						new Document("address",
								new Document().append("street", "XYZ, AB ROAD").append("zipcode", "452154")
										.append("state", "Haryana").append("location", "Chandigarh"))
												.append("name", "British School").append("school_id", "120320"),
				new Document("address",
						new Document().append("street", "ABC, XY Road").append("zipcode", "42211")
								.append("state", "Punjab").append("location", "Mohali")).append("name", "DAV")
										.append("school_id", "443211"),
				new Document("address",
						new Document().append("street", "SSS, Shadow").append("zipcode", "453226")
								.append("state", "Haryana").append("location", "Panchkula")).append("name", "DPS")
										.append("school_id", "754323"),
				new Document("address",
						new Document().append("street", "1233, Near Gopal").append("zipcode", "645322")
								.append("state", "Punjab").append("location", "Zirakpur"))
										.append("name", "Kendra Vidhalya").append("school_id", "653243")));
	}

	public static DeleteResult delete(String schoolId) {
		return db.getCollection("schools").deleteOne(new Document("school_id", schoolId));
	}

	public static DeleteResult deleteAll() {
		return db.getCollection("schools").deleteMany(new Document());
	}

	public static UpdateResult update(String schoolId) {
		return db.getCollection("schools").updateOne(new Document("school_id", schoolId),
				new Document("$set", new Document("name", "British International")).append("$currentDate",
						new Document("lastModified", Boolean.valueOf(true))));
	}
}
