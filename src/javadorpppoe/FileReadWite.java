package javadorpppoe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.ReadOnlyFileSystemException;

public class FileReadWite {
	FileReader fr = null;
	BufferedReader br = null;

	public FileReadWite() {
		try {
			fr = new FileReader("jsj.txt");
			br = new BufferedReader(fr);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	String Read() {

		String data = null;
		try {
			data = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (data != null) {
			// System.out.println(data);
			return data;
		} else
			return null;

	}

	void Write(String data) {
		try {
			RandomAccessFile randomFile = new RandomAccessFile("keyong.txt", "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.writeBytes("\n"+data);
			randomFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	public static void main(String[] args) throws Exception {
//		FileReadWite fileRendWite = new FileReadWite();
//       fileRendWite.Write("6666666666666");
//		
//	}
}
