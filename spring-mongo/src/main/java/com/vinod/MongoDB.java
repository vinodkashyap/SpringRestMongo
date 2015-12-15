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

	public static String insert() throws ParseException {
		db.getCollection("schools").insertMany(asList(
				new Document("address",
						new Document().append("street", "Sector 38C, Opposite Canara Bank").append("zipcode", "110026")
								.append("state", "Haryana").append("location", "Chandigarh"))
										.append("name", "British School").append("school_id", "1001"),
				new Document("address",
						new Document().append("street", "Phase 7B").append("zipcode", "160034")
								.append("state", "Punjab").append("location", "Mohali")).append("name", "DAV")
										.append("school_id", "1002"),
				new Document("address",
						new Document().append("street", "Sector 2A").append("zipcode", "134110")
								.append("state", "Haryana").append("location", "Panchkula")).append("name", "DPS")
										.append("school_id", "1003"),
				new Document("address",
						new Document().append("street", "Plot #1233, Sector 11").append("zipcode", "150230")
								.append("state", "Punjab").append("location", "Zirakpur"))
										.append("name", "Kendra Vidhalya").append("school_id", "1004"),
				new Document("address",
						new Document().append("street", "Sector D, Cantonment Area").append("zipcode", "160101")
								.append("state", "Punjab").append("location", "Chandigarh"))
										.append("name", "Army School").append("school_id", "1005")));
		return "Total Insert: " + db.getCollection("schools").count(new Document());
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
