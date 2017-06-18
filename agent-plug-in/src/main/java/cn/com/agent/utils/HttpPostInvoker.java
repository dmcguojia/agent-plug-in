package cn.com.agent.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpPostInvoker {
	private static final Logger logger = LoggerFactory
			.getLogger(HttpPostInvoker.class);

	public static String invokeMethod(String sendStr) throws Exception {
		logger.info("send msg:"+sendStr);
		StringBuilder result = new StringBuilder("");
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(
					"http://218.76.1.141:9092/mposquery/putAction.do");
			logger.info("send url:"+realUrl.getHost()+realUrl.getPath());
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Accept-Charset", "gbk");
			conn.setRequestProperty("contentType", "gbk");
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");

			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Charset", "gbk");
			conn.setConnectTimeout(Integer.parseInt("30000"));
			conn.setReadTimeout(Integer.parseInt("30000"));
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(new OutputStreamWriter(
					conn.getOutputStream(), "utf-8"));
			out.print(sendStr);
			out.flush();
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			logger.info(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				throw new Exception(ex.getMessage());
			}
		}
		return result.toString();

	}
}
