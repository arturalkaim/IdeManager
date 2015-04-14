package pt.alkart.idemanager.managers;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

import pt.alkart.idemanager.main.IdeManagerInt;
import pt.alkart.idemanager.objects.Idea;

import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class IdeManager_MONGODB implements IdeManagerInt<DBObject> {
	private DB db;
	private DBCollection ideas;

	@Override
	public boolean start() {
		// To directly connect to a single MongoDB server (note that this will
		// not auto-discover the primary even
		// if it's a member of a replica set:
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db = mongoClient.getDB("mydb");
		ideas = db.getCollection("ideas");
		return true;
	}

	@Override
	public boolean end() {
		//ideas.drop();
		return true;
	}

	@Override
	public DBObject buildIdea(Idea ide) {
		BasicDBObject ret = new BasicDBObject("_id", ide.getName()).append(
				Idea.NAME, ide.getName()).append(Idea.DESC, ide.getDesc());
		return ret;
	}

	@Override
	public void addIdea(Idea ide) {
		BasicDBObject query = new BasicDBObject(Idea.NAME, new BasicDBObject(
				"$eq", ide.getName()));
		if (ideas.find(query).count() > 0) {
			ideas.update(query, buildIdea(ide));
		} else
			ideas.insert(buildIdea(ide));
	}

	@Override
	public void removeIdea(Idea ide) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Idea> listIdeas() {
		DBCursor cursor = ideas.find();
		List<Idea> list = new LinkedList<Idea>();
		try {
			DBObject aux;
			while (cursor.hasNext()) {
				aux = cursor.next();
				Idea id = new Idea((String) aux.get(Idea.NAME),(List<String>) aux.get(Idea.DESC));
				list.add(id);
				System.out.println(id.toString());
			}
		} finally {
			cursor.close();
		}
		return list;
	}

}
