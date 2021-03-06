package br.com.unifacef.tic.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comentario")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private Integer Relevance;
	private String Title, Body;
	private Date CreatedAt;
	
	private Associate associate;
	private Postage postage;
	
	public Comment() {}

	public Comment(Integer id, Integer relevance, String title, String body, Date createdAt, Associate associate, Postage postage) {
		Id = id;
		Relevance = relevance;
		Title = title;
		Body = body;
		CreatedAt = createdAt;
		this.associate = associate;
		this.postage = postage;
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

	public Postage getPostage() {
		return postage;
	}

	public void setPostage(Postage postage) {
		this.postage = postage;
	}
	
	@Override
	public String toString() {
		return "Comment [Id=" + Id + ", Relevance=" + Relevance + ", Title=" + Title + ", Body=" + Body + ", CreatedAt="
				+ CreatedAt + ", associate=" + associate + ", postage=" + postage + "]";
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
		Comment other = (Comment) obj;
		return Objects.equals(Id, other.Id);
	}
}
