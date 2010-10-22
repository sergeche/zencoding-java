package test;

import ru.zencoding.JSExecutor;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSExecutor jsRunner = JSExecutor.getSingleton();
		ZenEditor editor = new ZenEditor();
		
		editor.setContent("hello\ndiv>p.example\nworld");
		editor.setCaretPos(19);
		
		System.out.println("Original content:");
		System.out.println(editor.getContent());
		
		jsRunner.runAction(editor, "expand_abbreviation");
		
		System.out.println("Processed content:");
		System.out.println(editor.getContent());
	}
}
