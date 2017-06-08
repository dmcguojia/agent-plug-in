package cn.com.agent.utils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

@SuppressWarnings("all")
public class CommonUtil {
	private static final Log log = LogFactory.getLog(CommonUtil.class);
	protected static final String CLASSPATH_URL_PREFIX = "classpath:";
	protected static final String FILE_URL_PREFIX = "file:";
	protected static final String HTTP_URL_PREFIX = "http:";
	protected static final String FTP_URL_PREFIX = "ftp:";
	public static final String HAIKE_CHANNEL_CODE="02";
	public static final String DOWNLOAD_ROOTPATH = "/download";
	
	public static final Map<String, String> BOOLEAN_MAP = new HashMap<String, String>();
	public static final Map<String, String> SEX_MAP = new HashMap<String, String>();
	static {
		BOOLEAN_MAP.put("Y", "是");
		BOOLEAN_MAP.put("N", "否");

		SEX_MAP.put("M", "男");
		SEX_MAP.put("F", "女");
	}

	public static String printBoolean(final String s) {
		return printMap(BOOLEAN_MAP, s);
	}

	public static String printSex(final String s) {
		return printMap(SEX_MAP, s);
	}

	public static <K, V> V printMap(final Map<K, V> map, final K key) {
		return null == key ? null : map.get(key);
	}

	public static Boolean isBoolean(String s) {
		if (null != s) {
			if ("Y".equalsIgnoreCase(s))
				return true;
			else if ("N".equalsIgnoreCase(s))
				return false;
		}
		return null;
	}

	public static int getDatePart(String part) {
		return getDatePart(new Date(), part);
	}

	public static int getDatePart(Date newDate, String part) {
		Calendar c = Calendar.getInstance();
		c.setTime(newDate);
		if ("YEAR".equalsIgnoreCase(part)) {
			return c.get(Calendar.YEAR);
		} else if ("MONTH".equalsIgnoreCase(part)) {
			return c.get(Calendar.MONTH);
		} else if ("DAY".equalsIgnoreCase(part)) {
			return c.get(Calendar.DAY_OF_MONTH);
		} else if ("HOUR".equalsIgnoreCase(part)) {
			return c.get(Calendar.HOUR_OF_DAY);
		} else if ("MINUTE".equalsIgnoreCase(part)) {
			return c.get(Calendar.MINUTE);
		} else if ("SECOND".equalsIgnoreCase(part)) {
			return c.get(Calendar.SECOND);
		} else if ("MILLISECOND".equalsIgnoreCase(part)) {
			return c.get(Calendar.MILLISECOND);
		} else
			throw new RuntimeException(
					"the argument part must be in [YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, MILLISECOND]");
	}

	public static void close(Closeable... cs) {
		if (null != cs) {
			for (Closeable c : cs) {
				if (null != c) {
					try {
						c.close();
					} catch (IOException e) {
						log.error(CommonUtil.class.getName() + "["
								+ getDateTime() + "] : " + e.toString());
					}
				}
			}
		}
	}

	public static <T extends Comparable<T>> T max(T... ts) {
		if (null == ts || ts.length < 2)
			throw new RuntimeException("args count must be greater than 2");

		T result = ts[0];
		for (T o : ts) {
			if (result.compareTo(o) == -1) {
				result = o;
			}
		}
		return result;
	}

	public static <T extends Comparable<T>> T min(T... ts) {
		if (null == ts || ts.length < 2)
			throw new RuntimeException("args count must be greater than 2");

		T result = ts[0];
		for (T o : ts) {
			if (result.compareTo(o) == 1) {
				result = o;
			}
		}
		return result;
	}

	public static <T> void removeItems(final List<T> list, T... items) {
		for (int i = list.size() - 1; i >= 0; i--) {
			if (null == items) {
				if (null == list.get(i))
					list.remove(i);
			} else {
				for (T t : items) {
					if (null == t) {
						if (null == list.get(i))
							list.remove(i);
					} else {
						if (t.equals(list.get(i))) {
							list.remove(i);
						}
					}
				}
			}
		}
	}

	public static String htmlEscape(String content) {
		if (null == content)
			return null;
		return content.replaceAll("  ", " &nbsp;").replaceAll("\r\n", "<br />");
	}

	public static Date secondAdd(final Date newDate, final int seconds) {
		if (null == newDate)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(newDate);
		c.set(Calendar.SECOND, c.get(Calendar.SECOND) + seconds);
		return c.getTime();
	}

	public static Timestamp secondAdd(final Timestamp newTime, final int seconds) {
		if (null == newTime)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(newTime);
		c.set(Calendar.SECOND, c.get(Calendar.SECOND) + seconds);
		return new Timestamp(c.getTime().getTime());
	}

	// get generic Class<T>
	public static <T> Class<T> getGenericClass(final Class baseClass,
			final int index) {
		Type genericType = baseClass.getGenericSuperclass();

		if (genericType instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) genericType)
					.getActualTypeArguments();
			if (null != params && params.length >= index) {
				if (params[index - 1] instanceof Class)
					return (Class<T>) params[index - 1];
			}
		}
		return null;
	}

	/**
	 * the date after "days" days of newDate if "days" > 0, otherwise, that is
	 * before "days" days of newDate
	 * 
	 * @param newDate
	 * @param days
	 * @return Date
	 */
	public static Date dateAdd(final Date newDate, final int days) {
		if (null == newDate)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(newDate);
		c.set(Calendar.DATE, c.get(Calendar.DATE) + days);
		return c.getTime();
	}

	/**
	 * 获取唯一文件名
	 * 
	 * @return String
	 */
	public synchronized static String getUniqueFilename(final String path) {
		StringBuilder result = new StringBuilder();
		result.append(System.currentTimeMillis());
		String randomStr = String.valueOf((int) (Math.random() * 10000));
		for (int i = randomStr.length(); i < 4; i++)
			result.append("0");
		result.append(randomStr);
		result.append("." + getExtension(path));
		return result.toString();
	}

	public static String getExtension(String path) {
		if (null == path)
			return null;
		if (path.indexOf(".") == -1)
			return "";
		else
			return unqualify(path);
	}

	public static String unqualify(String qualifiedName) {
		return StringUtils.unqualify(qualifiedName);
	}

	public static <T> String buildVariable(Class<T> clazz) {
		String fullName = clazz.getName();
		String simpleName = StringUtils.unqualify(fullName);
		if (simpleName.length() >= 2) { // IProductService => ProductService
			String s = simpleName.substring(0, 2);
			if (s.equals(s.toUpperCase())) {
				simpleName = simpleName.substring(1);
			}
		}
		return simpleName.substring(0, 1).toLowerCase()
				+ simpleName.substring(1);
	}

	/**
	 * 生成日期字符串[YYYY-MM-DD HH24:MI:SS]
	 * 
	 * @return String
	 */
	public static String getDateTime(final Date datetime) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime);
	}

	public static String getDateTime() {
		return getDateTime(new Date());
	}

	public static Date getDateTime(final String datetime) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datetime);
		} catch (ParseException e) {
		}
		return null;

	}

	/**
	 * get current date format[YYYY-MM-DD]
	 * 
	 * @return String
	 */
	public static String getDate(final Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public static String getDate() {
		return getDate(new Date());
	}

	public static Date getDate(final String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
		}
		return null;

	}

	/**
	 * parse to 'YYYY-MM-DD HH24:MI:SS'
	 * 
	 * @param datetime
	 * @return String
	 */
	public static String formatDateTime(final String datetime) {
		return getDateTime(getDateTime(datetime));
	}

	/**
	 * parse to 'YYYY-MM-DD'
	 * 
	 * @param strDate
	 *            String
	 * @return String
	 */
	public static String formatDate(final String date) {
		return getDate(getDate(date));
	}

	/**
	 * limit string length, not longer than maxLength characters <br />
	 * e.g. limitLength("你好1234", 4) return "你好12" that is a Chinese character
	 * uses two bytes <br />
	 * 
	 * @param s
	 *            String
	 * @param maxLength
	 *            int
	 * @return String
	 */
	public static String limitLength(String s, final int maxLength) {
		if (s == null)
			s = "";
		if (maxLength > 1) {
			s = s.replaceAll("<BR>", "\n");
			if (s.indexOf("width>screen") != -1)
				s = s.replace("width>screen", "");
			while (true) { 
				int start = s.indexOf("<");
				if (start == -1)
					break;
				int end = s.indexOf(">");
				if (end == -1)
					break;
				if (end <= start)
					break;
				s = s.substring(0, start) + s.substring(end + 1, s.length());
			}

			int intLength = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if ((int) c <= 255) { // 
					intLength += 1;
				} else { // 
					intLength += 2;
				}
				if (intLength >= maxLength) {
					s = s.substring(0, i + 1); // + "...";
					break;
				}
			}
		}
		return s;
	}

	/**
	 * check src isInclude dest, by separator
	 * 
	 * @param source
	 *            String
	 * @param destination
	 *            String
	 * @param separator
	 *            String
	 * @return boolean
	 */
	public static boolean isInclude(final String source, String destination,
			final String separator) {
		if (separator.length() > 0
				&& destination.length() >= separator.length()
				&& destination.length() >= source.length()) {
			if (!destination.substring(0, separator.length()).equals(separator)) {
				destination = separator + destination;
			}
			if (!destination.subSequence(
					destination.length() - separator.length(),
					destination.length()).equals(separator)) {
				destination += separator;
			}
			if (destination.indexOf(separator + source + separator) >= 0) {
				return true;
			}
		}
		return false;
	}

	public static URL getResource(final String resource) {
		return Thread.currentThread().getContextClassLoader().getResource(
				resource);
	}

	public static InputStream getResourceAsStream(final String resource) {
		String path = resource;
		if (path.startsWith(FILE_URL_PREFIX)) {
			path = path.substring(FILE_URL_PREFIX.length());
			try {
				return new FileInputStream(path);
			} catch (FileNotFoundException e) {
				return null;
			}
		} else {
			if (path.startsWith(CLASSPATH_URL_PREFIX)) {
				path = path.substring(CLASSPATH_URL_PREFIX.length());
				if (path.startsWith("/"))
					path = path.substring("/".length());
			} else if (path.startsWith(HTTP_URL_PREFIX)
					|| path.startsWith(FTP_URL_PREFIX)) {
			}
			try {
				URL url = getResource(path);
				if (null == url)
					url = new URL(path);
				return null == url ? null : url.openStream();
			} catch (IOException e) {
				return null;
			}
		}
	}

	/**
	 * load properties by file
	 * 
	 * @param fileResource
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Properties loadProperties(final InputStream input)
			throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(input);
		return p;
	}

	public static String getPropertyValue(final Properties prop,
			final String key, String defaultValue) {
		try {
			return prop.getProperty(key, defaultValue);
		} catch (Exception e) {
			log.error(e.toString());
			return null;
		}
	}

	public static Document loadXml(final InputStream input)
			throws DocumentException {
		return new SAXReader().read(input);
	}

	@SuppressWarnings( { "unused", "unchecked" })
	private static void testLoopXml(final String configuration)
			throws DocumentException {
		Document document = loadXml(getResourceAsStream(configuration));
		Element root = document.getRootElement();
		// ------------ loop all elements ----------
		for (Element element : (List<Element>) root.elements()) {
			System.out.println(element.getName() + " = " + element.getText());
			for (Attribute attribute : (List<Attribute>) element.attributes()) {
				System.out.println("**** " + attribute.getName() + " = "
						+ attribute.getValue());
			}
		}
		// ------------ single node ----------------
		Element single = root.element("single");
		System.out.println(single.getName() + " = " + single.getText());
		for (Attribute attribute : (List<Attribute>) single.attributes()) {
			System.out.println("**** " + attribute.getName() + " = "
					+ attribute.getValue());
		}
	}
}