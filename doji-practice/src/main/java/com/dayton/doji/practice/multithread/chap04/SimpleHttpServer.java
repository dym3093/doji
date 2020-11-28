package com.dayton.doji.practice.multithread.chap04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简单Http服务器
 * @author Martin Deng
 * @since 2020-11-28 13:15
 */
public class SimpleHttpServer {
	/** 处理HttpRequest的线程池 */
	private static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(1);
	/** SimpleHttpServer 的根路径 */
	private static String basePath;
	private static ServerSocket serverSocket;
	/** 服务监听端口 */
	private static int port = 8080;

	/**
	 * 设置端口
	 * @param port  端口号
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/28 13:24
	 */
	public static void setPort(int port){
		if (port > 0){
			SimpleHttpServer.port = port;
		}
	}

	/**
	 * 设置根路径
	 * @param basePath	根路径
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/28 13:25
	 */
	public static void setBasePath(String basePath){
		if (basePath != null && new File(basePath).exists()
				&& new File(basePath).isDirectory()){
			SimpleHttpServer.basePath = basePath;
		}
	}

	/**
	 * 启动SimpleHttpServer
	 * @return void
	 * @author Martin Deng
	 * @since 2020/11/28 13:27
	 */
	public static void start() throws IOException {
		serverSocket = new ServerSocket(port);
		Socket socket;
		while ((socket = serverSocket.accept()) != null){
			// 接受一个客户端Socket，生成一个HttpRequestHandler(socket)放入线程池执行
			threadPool.execute(new HttpRequestHandler(socket));
		}
		serverSocket.close();
	}

	static class HttpRequestHandler implements Runnable{
		private Socket socket;

		public HttpRequestHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			String line = null;
			BufferedReader reader = null;
			BufferedReader br = null;
			PrintWriter out = null;
			InputStream in = null;

			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String header = reader.readLine();
				// 由相对路径计算出绝对路径
				String filePath = basePath + header.split(" ")[1];
				out = new PrintWriter(socket.getOutputStream());
				// 如果请求资源的后缀未jpg或者ico，则读取资源并输出
				if (filePath.endsWith("jpg") || filePath.endsWith("ico")){
					in = new FileInputStream(filePath);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					int i = 0;
					while ((i = in.read()) != -1){
						baos.write(i);
					}
					byte[] array = baos.toByteArray();
					out.println("HTTP/1.1 200 OK");
					out.println("Server: Molly");
					out.println("Content-Type: image/jpeg");
					out.println("Content-Length: " + array.length);
					out.println("");
					socket.getOutputStream().write(array, 0, array.length);
				}else {
					br = new BufferedReader(new InputStreamReader(new
							FileInputStream(filePath)));
					out = new PrintWriter(socket.getOutputStream());
					out.println("HTTP/1.1 200 OK");
					out.println("Server: Molly");
					out.println("Content-Type: text/html; charset=UTF-8");
					out.println("");
					while ((line = br.readLine()) != null){
						out.println(line);
					}
				}
				out.flush();
			} catch (IOException e) {
				out.println("HTTP/1.1 500");
				out.println("");
				out.flush();
			}finally {
				close(br, in, reader, out, socket);
			}
		}

		/**
		 * 关闭流或Socket
		 * @param closeables 流或Socket
		 * @return void
		 * @author Martin Deng
		 * @since 2020/11/28 13:35
		 */
		private static void close(Closeable... closeables){
			if (closeables != null){
				for (Closeable closeable : closeables){
					try {
						closeable.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
