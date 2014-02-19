package com.mike.models;

import java.util.Collections;
import java.util.LinkedList;


import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import com.mike.stores.*;

public class MemberModel {
	Cluster cluster;
	
	public MemberModel()
	{
	}


	public void setCluster(Cluster cluster)
	{
		this.cluster=cluster;
	}
	
	private Session createSession() 
	{
		Session session = cluster.connect("tweetspace");
		return session;
	}
	
	public boolean AddUser(String fname, String sname, String handle, String email, String password)
	{
		boolean success = false;
		Session session = createSession();
		PreparedStatement statement = session.prepare("SELECT * FROM users WHERE email = '" + email + "' ALLOW FILTERING"); //create select query
		BoundStatement boundStatement = new BoundStatement(statement);
		ResultSet rs = session.execute(boundStatement);
		if (rs.isExhausted())
		{
			statement = session.prepare("SELECT * FROM users WHERE handle = '" + handle + "' ALLOW FILTERING"); //create select query
			boundStatement = new BoundStatement(statement);
			rs = session.execute(boundStatement);
			if (rs.isExhausted()) 
			{
				statement = session.prepare("INSERT INTO users (user_id, name, lname, handle,email,password) VALUES (now(),'" + fname + "', '" + sname + "', '" + handle + "', '" + email + "', '" + password + "')"); //create add query
				try
				{
					boundStatement = new BoundStatement(statement);
					session.execute(boundStatement);
					success = true;
				}
				catch(Exception e)
				{
					success = false;
				}
			}
			else
			{
				success = false;
			}
		} 
		else
		{
			success = false;
		}
		session.close();
		return success;
	}
	
	public String Login(String email, String password)
	{
		String username = null;
		Session session = createSession();
		PreparedStatement statement = session.prepare("SELECT * FROM users WHERE email = '" + email + "'ALLOW FILTERING");
		BoundStatement boundStatement = new BoundStatement(statement);
		ResultSet rs = session.execute(boundStatement); //execute command
		if (rs.isExhausted()) //if there are no barks
		{
			
		} 
		else 
		{
			for (Row row : rs)
			{
				if(row.getString("password").equals(password))
				{
					username = row.getString("email");
				}
			}
		}
		session.close();
		return username;
	}
	
	public LinkedList<TweetStore> getTweets(String username)
	{
		LinkedList<TweetStore> tweetList = new LinkedList<TweetStore>();
		
		//TODO
		/*Session session = createSession();
		PreparedStatement statement = session.prepare("SELECT * FROM users WHERE email = '" + email + "'ALLOW FILTERING");
		BoundStatement boundStatement = new BoundStatement(statement);
		ResultSet rs = session.execute(boundStatement); //execute command
		if (rs.isExhausted()) //if there are no barks
		{
			System.out.println("No Tweets Found");
			
		} */
		
		return tweetList;
	}



}
