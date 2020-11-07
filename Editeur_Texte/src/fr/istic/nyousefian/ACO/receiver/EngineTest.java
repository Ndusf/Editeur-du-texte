package fr.istic.nyousefian.ACO.receiver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class EngineTest { 
 
	private Engine engine; 
	
	
	public void insertChaine(String s) {
		int longueur = s.length();
		for ( int i = 0; i < longueur ; i++ ) { 
			engine.insert(s.substring(i,i+1)); 
		}
	}
		 
	@BeforeEach
	void setUp() throws Exception {
	  engine = new EnginImpl(); 
	  }
	
	@Test
	@DisplayName("V�rification de la saisie simple")
	 public void test1(){
		this.insertChaine("ABCD");
		assertEquals("ABCD", engine.getBufferContents());
	 }
	
	@Test
	@DisplayName("V�rification de la double saisie")
	void test2() {
		this.insertChaine("ABCD");
		this.insertChaine("EFG");
		assertEquals("ABCDEFG", engine.getBufferContents());
	}
	
	@Test
	@DisplayName("V�rification de la saisie d'un autre texte apr�s le d�placement du curseur au d�but du texte")
	 public void test3(){
		this.insertChaine("ABC");
		engine.getSelection().moveCursor(-3);
		this.insertChaine("DEF");
		assertEquals("DEFABC", engine.getBufferContents());
	 }
		
 
	@Test
	@DisplayName("V�rification du buffer vide")
	void test4(){
		assertEquals("", engine.getClipboardContents());
	}
	
	@Test
	@DisplayName("V�rification de la s�lection active")
	void test5() {
		this.insertChaine("ABC");
		engine.getSelection().moveCursor(-2);
		engine.getSelection().setMarker();
		this.insertChaine("DEF");
		assertEquals("ADEFBC", engine.getBufferContents());
	}
	
	@Test
	@DisplayName("V�rification simple de la m�thode copy")
	void test6() {
		this.insertChaine("ABC");
		engine.getSelection().moveCursor(-3);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(0);
		engine.copy();
		assertEquals("", engine.getClipboardContents());
		assertEquals("ABC", engine.getBufferContents());
		}
	
	@Test
	@DisplayName("V�rification de la copie enti�re de la cha�ne de caract�res")
	void test7() {
		this.insertChaine("ABC");
		engine.getSelection().moveCursor(-3);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(3);
		engine.copy();
		assertEquals("ABC", engine.getClipboardContents());
		assertEquals("ABC", engine.getBufferContents());
		}
	
	@Test
	@DisplayName("V�rification de la m�thode copy")
	void tes8() {
		this.insertChaine("ABC");
		engine.getSelection().moveCursor(-2);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(2);
		engine.copy();
		assertEquals("BC", engine.getClipboardContents());
		assertEquals("ABC", engine.getBufferContents());
		}
	
	@Test
	@DisplayName("Deuxi�me v�rification de la m�thode copy")
	void test9() {
		this.insertChaine("ABC");
		engine.getSelection().moveCursor(-2);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(-1);
		engine.copy();
		assertEquals("A", engine.getClipboardContents());
		assertEquals("ABC", engine.getBufferContents());
		}
	
	@Test
	@DisplayName("V�rification simple de la m�thode cut")
	void testCut10() {
		this.insertChaine("ABCD");
		engine.getSelection().moveCursor(-4);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(0);
		engine.cut();
		assertEquals("", engine.getClipboardContents());
		assertEquals("ABCD", engine.getBufferContents());	
	} 

	@Test
	@DisplayName("V�rification de la m�thode cut")
	void test11() {
		this.insertChaine("ABCD");
		engine.getSelection().moveCursor(-3);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(2);
		engine.cut();
		assertEquals("BC", engine.getClipboardContents());
		assertEquals("AD", engine.getBufferContents());	
	}
	@Test
	@DisplayName("Deuxi�me v�rification de la m�thode cut")
	void test12() {
		this.insertChaine("ABCD");
		engine.getSelection().moveCursor(-2);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(-1);
		engine.cut();
		assertEquals("B", engine.getClipboardContents());
		assertEquals("ACD", engine.getBufferContents());	
	}
	@Test
	@DisplayName("V�rification des m�thodes copy et paste lorsqu'on colle des caract�res apr�s d'autres")
	void testCopyPaste13() {
		this.insertChaine("ABCD");
		engine.getSelection().moveCursor(-2);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(2);
		engine.copy();
		engine.paste();
		assertEquals("CD",engine.getClipboardContents());
    	assertEquals("ABCDCD", engine.getBufferContents());        
	}
	@Test
	@DisplayName("V�rification des m�thodes copy et paste lorsqu'on remplace des caract�res par d'autres ")
	void testCopyPaste14() {
		this.insertChaine("ABCD");
		engine.getSelection().moveCursor(-2);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(-2);
		engine.copy();
		engine.paste();
		assertEquals("AB",engine.getClipboardContents());
    	assertEquals("ABCD", engine.getBufferContents());        
	}
	@Test
	@DisplayName("V�rification des m�thodes cut et paste")
	void testCutPaste15() {
		this.insertChaine("ABCDEF");
		engine.getSelection().moveCursor(-3);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(2);
		engine.cut();
		assertEquals("DE",engine.getClipboardContents());
    	assertEquals("ABCF", engine.getBufferContents());        
    	engine.getSelection().moveCursor(-1);
    	engine.paste();
    	assertEquals("DE", engine.getClipboardContents());  
    	assertEquals("ABCFDE", engine.getBufferContents());        
	}
	@Test
	@DisplayName("Deuxi�me v�rification des m�thodes cut et paste")
	void testCutPaste16() {
		this.insertChaine("ABCDEF");
		engine.getSelection().moveCursor(-3);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(-3);
		engine.cut();
		assertEquals("ABC",engine.getClipboardContents());
    	assertEquals("DEF", engine.getBufferContents());        
    	engine.getSelection().moveCursor(0);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(1);
    	engine.paste();
    	assertEquals("ABC", engine.getClipboardContents());  
    	assertEquals("DABCEF", engine.getBufferContents());        
	}
	@Test 
	@DisplayName("V�rification de la m�thode delete en supprimant un caract�re")
	 public void test17(){
		this.insertChaine("ABCD");
		engine.getSelection().moveCursor(-2);
		engine.getSelection().setMarker();
		engine.getSelection().moveCursor(1);
		engine.delete();
		assertEquals("ABD", engine.getBufferContents());
	 }	
}
