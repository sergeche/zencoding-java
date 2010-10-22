package test;

import ru.zencoding.IZenEditor;
import ru.zencoding.SelectionData;

public class ZenEditor implements IZenEditor {
	private String content = "";
	private int caretPos = 0;
	
	@Override
	public void createSelection(int start, int end) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getCaretPos() {
		return caretPos;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public String getCurrentLine() {
		SelectionData sel = getCurrentLineRange();
		return getContent().substring(sel.getStart(), sel.getEnd());
	}

	@Override
	public SelectionData getCurrentLineRange() {
		int len = getContent().length();
		int start = 0;
		int end = len - 1;
		char ch;
		
		// search left
		for (int i = getCaretPos() - 1; i > 0; i--) {
			ch = getContent().charAt(i);
			if (ch == '\n' || ch == '\r') {
				start = i + 1;
				break;
			}
		}
		
		// search right
		for (int j = getCaretPos(); j < len; j++) {
			ch = getContent().charAt(j);
			if (ch == '\n' || ch == '\r') {
				end = j;
				break;
			}
		}
		
		return new SelectionData(start, end);
	}

	@Override
	public String getFilePath() {
		return "local";
	}

	@Override
	public String getProfileName() {
		return "xhtml";
	}

	@Override
	public String getSelection() {
		return "";
	}

	@Override
	public SelectionData getSelectionRange() {
		return new SelectionData(caretPos, caretPos);
	}

	@Override
	public String getSyntax() {
		return "html";
	}

	@Override
	public String prompt(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void replaceContent(String value) {
		this.replaceContent(value, 0, content.length());
	}

	@Override
	public void replaceContent(String value, int start) {
		this.replaceContent(value, start, start);
	}

	@Override
	public void replaceContent(String value, int start, int end) {
		String content = getContent();
		setContent(content.substring(0, start) + value + content.substring(end));
	}

	@Override
	public void setCaretPos(int pos) {
		caretPos = pos;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void print(String msg) {
		System.out.println("ZE:" + msg);
	}
}
