package sabreacademy.scrum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class ScanerReader implements ReaderInterface {
	static /**/ Scanner scan = null; // comment 2
	

	ScanerReader() {
		if (scan == null) {
			// comment 1
			scan = new Scanner(System.in);
		}
	}

	@Override
	public boolean hasNext() {
		return scan.hasNext();
	}

	@Override
	public String next() {
		return scan.next();
	}

	@Override
	public boolean isInitialized() {
		try {
			return scan != null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}

class ReaderImpl implements ReaderInterface {
	static BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

	ReaderImpl() {}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public String next() {
		try {
			return bufferRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public boolean isInitialized() {
		try {
			return bufferRead != null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}


class Writer {
	public void print(String s) {
		System.out.print(s);
	}
	
	public void println(String x) {
		System.out.println(x);
	}
}

public class EPB {

	public static void main(String[] args) {

		Writer writer = new Writer();

		try {
			writeMenu(writer);			
			showPrompt(writer);
			
			ReaderInterface reader = new ScanerReader();
			checkReader(reader);
			while (reader.hasNext()) {
				String str = readImput(reader);
				performAction(writer, str);
			}
		} catch (Exception ex) {
			logException(ex);
		}
	}

	private static void checkReader(ReaderInterface reader) throws Exception {
		boolean isInitialized = !reader.isInitialized();
		if (isInitialized)
			throw new Exception("");
	}

	private static void logException(Exception ex) {
		ex.printStackTrace();
	}

	private static void performAction(Writer writer, String str) {
		writer.println(str);
	}

	private static String readImput(ReaderInterface reader) {
		return reader.next();
	}

	private static void showPrompt(Writer writer) {
		writer.print("ePB> ");
	}

	private static void writeMenu(Writer writer) {
		writer.println("Menu: ");
		writer.println("\teXit");
		writer.println("\tAdd item");
		writer.println("\tChange item");
		writer.println("\tRemove item");
		writer.println( "\tHelp item");
	}
}
