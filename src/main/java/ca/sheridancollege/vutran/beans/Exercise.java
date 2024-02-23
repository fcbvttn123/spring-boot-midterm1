package ca.sheridancollege.vutran.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Exercise {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private int duration;
	private String performDesc;
	private int calories;
	private String equipmentDesc;
}

/*
[
 
 {
	 "title": "Ex1", 
	 "duration": 30, 
	 "performDesc": "performDesc1", 
	 "calories": 1000,
	 "equipmentDesc": "equipmentDesc1" 
 },
 
 {
	 "title": "Ex2", 
	 "duration": 15, 
	 "performDesc": "performDesc2", 
	 "calories": 2000,
	 "equipmentDesc": "equipmentDesc2"
 }
 
]
*/
