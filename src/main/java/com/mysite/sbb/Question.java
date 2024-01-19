package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	//질문 정보를 저장하는 테이블
	
	//@Entity: DB의 테이블과 매핑
		//Question: 테이블명
		//필드: 테이블의 컬럼과 연결
	
	//@Id: 필드 위에 할당, Primary Key(중복된 값을 못 넣도록 설정), 테이블에 반드시 1개가 적용
	//@GeneratedValue: 자동으로 값을 증가해서 생성해줌, @Id 같이 부여
	//@Column: 컬럼의 제약 사항을 적용
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(length=200)
	private String subject;
	
	@Column(length=20000)
	private String content;
	private LocalDateTime createDate;
	
	//해당 질문(Question): 1, 질문에 대한 답변(Answer): 다
	//하나의 질문에 대해서 모든 답변을 가져올 수 있다.
	//cascade=CascadeType.REMOVE	<- 질문이 제거될 때, 질문에 해당하는 모든 답변을 함께 제거
	@OneToMany(mappedBy = "question", cascade=CascadeType.REMOVE)
	private List<Answer> answerList;

}
