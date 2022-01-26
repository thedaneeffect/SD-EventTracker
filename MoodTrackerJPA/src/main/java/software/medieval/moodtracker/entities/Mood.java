package software.medieval.moodtracker.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(of={"id", "userId"})
@IdClass(MoodId.class)
public class Mood implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@JsonProperty("date")
	private String id;
	@Id
	@JsonIgnore // we don't need to transmit this
	private int userId;
	private int value;
	private String description;

}
