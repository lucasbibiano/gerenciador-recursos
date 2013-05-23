package views.helpers;

public class SubnavItem {
	private String linkTo;
	private String text;
	
	public SubnavItem(String linkTo, String text) {
		this.setLinkTo(linkTo);
		this.setText(text);
	}

	public String getLinkTo() {
		return linkTo;
	}

	public void setLinkTo(String linkTo) {
		this.linkTo = linkTo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
