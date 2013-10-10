package idv.plurk.rpg.model;

public class Emotion {
	public enum Emote {
		NORMAL, HAPPY, SAD, SURPRISE, ANGRY
	}

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Emote getEmote() {
		return emote;
	}

	public void setEmote(String emote) {
		this.emote = Emote.valueOf(emote);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getNpc() {
		return npc;
	}

	public void setNpc(Integer npc) {
		this.npc = npc;
	}

	private Emote emote;

	private String url;

	private Integer npc;
}