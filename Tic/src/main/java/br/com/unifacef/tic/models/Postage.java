package br.com.unifacef.tic.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Postage {
	private Integer Id, Relevance;
	private String Title, Body;
	private Date CreatedAt;
	
	private Associate associate;
	private ArrayList<Comment> comments;
	
	public Postage() {}

	public Postage(Integer id, Integer relevance, String title, String body, Date createdAt, Associate associate) {
		Id = id;
		Relevance = relevance;
		Title = title;
		Body = body;
		CreatedAt = createdAt;
		this.associate = associate;
		this.comments = new ArrayList<>();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getRelevance() {
		return Relevance;
	}

	public void setRelevance(Integer relevance) {
		Relevance = relevance;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}

	public Associate getAssociate() {
		return associate;
	}

	public void setAssociate(Associate associate) {
		this.associate = associate;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void addComments(Comment comment) {
		this.comments.add(comment);
	}
	
	public void deleteComments(Comment comment) {
		this.comments.remove(comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Postage other = (Postage) obj;
		return Objects.equals(Id, other.Id);
	}
}
