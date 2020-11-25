package com.dayton.doji.practice.multithread.chap04;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author Martin Deng
 * @since 2020-11-25 16:18
 */
public class Piped {

	public static void main(String[] args) throws IOException {
		PipedReader in = new PipedReader();
		PipedWriter out = new PipedWriter();
		out.connect(in);
		Thread printThread = new Thread(new Print(in), "PrintThread");
		printThread.start();
		int receive;
		try {
			while ((receive = System.in.read()) != -1){
				out.write(receive);
			}
		} finally {
			out.close();
		}
	}

	static class Print implements Runnable{

		private PipedReader in;

		public Print(PipedReader in) {
			this.in = in;
		}

		@Override
		public void run() {
			int receive;
			try {
				while ((receive = in.read()) != -1){
					System.out.println((char)receive);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
