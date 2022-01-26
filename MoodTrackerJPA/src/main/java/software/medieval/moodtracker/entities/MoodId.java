package software.medieval.moodtracker.entities;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoodId implements Serializable {
	private static final long serialVersionUID = 7628634965042144042L;
	private String id;
	@Column(name="user_id")
	private int userId;
	
}
