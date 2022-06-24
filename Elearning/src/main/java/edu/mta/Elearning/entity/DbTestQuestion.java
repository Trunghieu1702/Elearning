package edu.mta.Elearning.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logunittestdetails")
public class DbTestQuestion extends BaseEntity{
	
	@Id
	@Column(name = "QuestionId")
	private int QuestionId;
	
	@Column(name = "QuestionType")
	private int QuestionType;
	
	@Column(name = "QuestionInstruction")
	private int QuestionInstruction;
	
	@Column(name = "QuestionInstructionTranslated")
	private int QuestionInstructionTranslated;
	
	@Column(name = "QuestionText")
	private int QuestionText;
	
	@Column(name = "QuestionTextTranslated")
	private Timestamp QuestionTextTranslated;
	
	@Column(name = "ExplainText")
	private int ExplainText;
	
	@Column(name = "ExplainTextTranslated")
	private int ExplainTextTranslated;
	
	@Column(name = "ScriptHint")
	private int ScriptHint;
	
	@Column(name = "ScriptHintTranslated")
	private int ScriptHintTranslated;
	
	@Column(name = "WordsNote")
	private int WordsNote;
	
	@Column(name = "Correct")
	private int Correct;
	
	@Column(name = "CreationTime")
	private Timestamp CreationTime;
	
	@Column(name = "LastModificationTime")
	private Timestamp LastModificationTime;

	public int getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}

	public int getQuestionType() {
		return QuestionType;
	}

	public void setQuestionType(int questionType) {
		QuestionType = questionType;
	}

	public int getQuestionInstruction() {
		return QuestionInstruction;
	}

	public void setQuestionInstruction(int questionInstruction) {
		QuestionInstruction = questionInstruction;
	}

	public int getQuestionInstructionTranslated() {
		return QuestionInstructionTranslated;
	}

	public void setQuestionInstructionTranslated(int questionInstructionTranslated) {
		QuestionInstructionTranslated = questionInstructionTranslated;
	}

	public int getQuestionText() {
		return QuestionText;
	}

	public void setQuestionText(int questionText) {
		QuestionText = questionText;
	}

	public Timestamp getQuestionTextTranslated() {
		return QuestionTextTranslated;
	}

	public void setQuestionTextTranslated(Timestamp questionTextTranslated) {
		QuestionTextTranslated = questionTextTranslated;
	}

	public int getExplainText() {
		return ExplainText;
	}

	public void setExplainText(int explainText) {
		ExplainText = explainText;
	}

	public int getExplainTextTranslated() {
		return ExplainTextTranslated;
	}

	public void setExplainTextTranslated(int explainTextTranslated) {
		ExplainTextTranslated = explainTextTranslated;
	}

	public int getScriptHint() {
		return ScriptHint;
	}

	public void setScriptHint(int scriptHint) {
		ScriptHint = scriptHint;
	}

	public int getScriptHintTranslated() {
		return ScriptHintTranslated;
	}

	public void setScriptHintTranslated(int scriptHintTranslated) {
		ScriptHintTranslated = scriptHintTranslated;
	}

	public int getWordsNote() {
		return WordsNote;
	}

	public void setWordsNote(int wordsNote) {
		WordsNote = wordsNote;
	}

	public int getCorrect() {
		return Correct;
	}

	public void setCorrect(int correct) {
		Correct = correct;
	}

	public Timestamp getCreationTime() {
		return CreationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		CreationTime = creationTime;
	}

	public Timestamp getLastModificationTime() {
		return LastModificationTime;
	}

	public void setLastModificationTime(Timestamp lastModificationTime) {
		LastModificationTime = lastModificationTime;
	}
	
	
}
