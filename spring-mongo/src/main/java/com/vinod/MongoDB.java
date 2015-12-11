package com.vinod;

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
				.insertOne(new Document("address",
						new Document().append("street", "XYZ, AB ROAD").append("zipcode", "452154")
								.append("state", "Haryana").append("location", "Chandigarh"))
										.append("name", "British School").append("school_id", "120320"));
		db.getCollection("schools")
				.insertOne(new Document("address",
						new Document().append("street", "ABC, XY Road").append("zipcode", "42211")
								.append("state", "Punjab").append("location", "Mohali")).append("name", "DAV")
										.append("school_id", "443211"));
		db.getCollection("schools")
				.insertOne(new Document("address",
						new Document().append("street", "SSS, Shadow").append("zipcode", "453226")
								.append("state", "Haryana").append("location", "Panchkula")).append("name", "DPS")
										.append("school_id", "754323"));
		db.getCollection("schools")
				.insertOne(new Document("address",
						new Document().append("street", "1233, Near Gopal").append("zipcode", "645322")
								.append("state", "Punjab").append("location", "Zirakpur"))
										.append("name", "Kendra Vidhalya").append("school_id", "653243"));
		db.getCollection("schools")
				.insertOne(new Document("address",
						new Document().append("street", "HHLO, LEAP Nagar").append("zipcode", "987675")
								.append("state", "Punjab").append("location", "Derabassi")).append("name", "Satluj")
										.append("school_id", "989776"));
	}

	public static DeleteResult delete(String schoolId) {
		return db.getCollection("schools").deleteMany(new Document("school_id", schoolId));
	}

	public static UpdateResult update(String schoolId) {
		return db.getCollection("schools").updateOne(new Document("school_id", schoolId),
				new Document("$set", new Document("name", "British International")).append("$currentDate",
						new Document("lastModified", Boolean.valueOf(true))));
	}
}
