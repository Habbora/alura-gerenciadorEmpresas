package br.com.habbora.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileDataObject {
	
	private String dir;
	
	public FileDataObject(String dir) {
		this.dir = dir;
	}
	
	public void save(Object obj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(dir);
			try (ObjectOutputStream ObjectOut = new ObjectOutputStream(fileOut)) {
				ObjectOut.writeObject(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object load() {
		Object obj;
		try {
			FileInputStream fileIn = new FileInputStream(dir);
			try(ObjectInputStream ObjectIn = new ObjectInputStream(fileIn)) {
				obj = ObjectIn.readObject();
			}
			return obj;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void delete() {
		try {
			File file = new File(dir);
			file.delete();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
