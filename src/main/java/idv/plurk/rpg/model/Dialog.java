package idv.plurk.rpg.model;

import idv.plurk.rpg.model.Emotion.Emote;

public class Dialog {
	public enum Type {
		CHAT, SYSTEM
	}

	private Integer npcId;
	private Integer next;
	private Integer id;
	private Emote emotion;
	private Type type;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getNpcId() {
		return npcId;
	}

	public void setNpcId(Integer npcId) {
		this.npcId = npcId;
	}

	public Integer getNext() {
		return next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Emote getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = Emote.valueOf(emotion);
	}

	public Type getType() {
		return type;
	}

	public void setType(String type) {
		this.type = Type.valueOf(type);
	}
}
