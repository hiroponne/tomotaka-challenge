package jp.ac.keio.sfc.ht.cpsf.hiropon.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class Crawler extends HTMLEditorKit.ParserCallback {

	public Crawler(URL url) {
		Reader reader;
		try {
			/** connect and get contents */
			URLConnection connection = url.openConnection();
			connection.connect();

			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "JISAutoDetect"));
			ParserDelegator parserDelegator = new ParserDelegator();

			/** parse contents */
			parserDelegator.parse(reader, this, true);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> list = new ArrayList<String>();

	@Override
	public void handleStartTag(HTML.Tag tag, MutableAttributeSet attr, int pos) {
		if (tag.equals(HTML.Tag.A)) {
			System.out.println(attr.toString());
		}
	}

	@Override
	public void handleEndTag(HTML.Tag tag, int argi) {
		if (tag.equals(HTML.Tag.A)) {

		}
	}

	@Override
	public void handleText(char[] data, int pos) {
		String text = new String(data);

	}

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.ht.sfc.keio.ac.jp");
			Crawler c = new Crawler(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
