package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownAppServlet extends HttpServlet {

	ServletConfig config;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * super.init(config); this.config = config; // 以流的形式下载文件。 try { //
	 * 读IOS文件存到内存中 InputStream fis = new BufferedInputStream(new
	 * FileInputStream( IOSFILE)); byte[] buffer = new byte[fis.available()];
	 * try { fis.read(buffer); } catch (Exception e) { log.error(e); } finally {
	 * fis.close(); } System.out.println("IOS文件大小：" + buffer.length);
	 * HashMap<String, Object> iosMap = new HashMap<String, Object>(); //
	 * path是指欲下载的文件的路径。 File file = new File(IOSFILE); // 取得文件名。 String filename
	 * = file.getName(); iosMap.put("fileName", filename); iosMap.put("length",
	 * file.length()); iosMap.put("buffer", buffer);
	 * config.getServletContext().setAttribute("iosBuffer", iosMap);
	 * 
	 * // 读ADR文件存到内存中 BufferedInputStream in = new BufferedInputStream( new
	 * FileInputStream(ADRFILE)); byte[] adrBuffer = new byte[in.available()];
	 * try { in.read(adrBuffer); } catch (Exception e) { log.error(e); } finally
	 * { in.close(); } HashMap<String, Object> adrMap = new HashMap<String,
	 * Object>(); // path是指欲下载的文件的路径。 File adrFile = new File(ADRFILE); //
	 * 取得文件名。 String adrname = adrFile.getName(); adrMap.put("fileName",
	 * adrname); adrMap.put("length", adrFile.length()); adrMap.put("buffer",
	 * adrBuffer); System.out.println("ADR文件大小：" + adrBuffer.length);
	 * config.getServletContext().setAttribute("adrBuffer", adrMap); } catch
	 * (Exception e) { log.error(e); } }
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {

		System.out.println("下载APP");
		String userAgent = request.getHeader("user-agent").toUpperCase();
		String path = null;

		String fileName = request.getParameter("fileName");
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String flag = request.getParameter("flag");
			if (flag != null && !"".equals(flag)) {//用户选择下载
				if (userAgent.indexOf("MICROMESSENGER") == -1) {
					if (flag.equals("ios")) {// 如果用户选择了下载IOS版客户端
						/*response.sendRedirect("ios_temp.jsp?fileName="
								+ fileName);
						return;*/
						//path = "D:\\" + fileName + ".ios";
						path =fileName+".ipa";
					} else if ("android".equals(flag)) {// 如果用户选择了下载ANDROID版客户端
						/*
						 * if (config.getServletContext()
						 * .getAttribute("adrBuffer") != null) {// 如果内存中有则从内存中取
						 * System.out.println("用户手动选择下载ADR，从内存中取");
						 * HashMap<String, Object> map = (HashMap<String,
						 * Object>) config .getServletContext().getAttribute(
						 * "adrBuffer"); byte[] buffer = (byte[])
						 * map.get("buffer"); // 清空response response.reset(); //
						 * 设置response的Header
						 * response.addHeader("Content-Disposition",
						 * "attachment;filename=" + new
						 * String(map.get("fileName") .toString().getBytes()));
						 * response.addHeader("Content-Length", "" +
						 * map.get("length"));
						 * response.addHeader("Content-Type",
						 * "application/vnd.android.package-archive"); //
						 * response.setContentType("application/octet-stream");
						 * OutputStream toClient = new BufferedOutputStream(
						 * response.getOutputStream()); try {
						 * toClient.write(buffer); toClient.flush(); } catch
						 * (Exception e) { log.error(e); } finally {
						 * toClient.close(); } return; }
						 */
						
						//path = "D:\\" + fileName + ".apk";
						path =fileName+".apk";
					}
				} else {//微信浏览器
					if (flag.equals("android")) {
						request.getRequestDispatcher(
								"tip.jsp?fileName=" + fileName).forward(
								request, response);
						return;
					} else {
//						response.sendRedirect("ios_temp.jsp?fileName="
//								+ fileName);
//						return;
						request.getRequestDispatcher(
								"tip.jsp?fileName=" + fileName).forward(
								request, response);
						return;
					}
				}
			} else {// ********************************系统根据用户的手机系统自动选择下载版本************************************
				if (userAgent.indexOf("MICROMESSENGER") == -1) {

					if (userAgent.indexOf("IPHONE") != -1
							|| userAgent.indexOf("IPAD") != -1) {// 如果是苹果，则下载IOS
						/*response.sendRedirect("ios_temp.jsp?fileName="
								+ fileName);
						return;*/
						//path = "D:\\" + fileName + ".ios";
						path =fileName+".ipa";
					} else if (userAgent.indexOf("ANDROID") != -1
							|| userAgent.indexOf("ADR") != -1) {// 如果是Android则下载APK
						/*
						 * if (config.getServletContext()
						 * .getAttribute("adrBuffer") != null) {// 如果内存中有则从内存中取
						 * System.out.println("系统自动选择下载adr，从内存中取");
						 * HashMap<String, Object> map = (HashMap<String,
						 * Object>) config .getServletContext().getAttribute(
						 * "adrBuffer"); byte[] buffer = (byte[])
						 * map.get("buffer"); // 清空response response.reset(); //
						 * 设置response的Header //
						 * response.addHeader("Content-Disposition", //
						 * "attachment;filename=" + "HGT.apk");
						 * response.addHeader("Content-Disposition",
						 * "attachment;filename=" + new
						 * String(map.get("fileName") .toString().getBytes()));
						 * response.addHeader("Content-Length", "" +
						 * map.get("length")); //
						 * response.setContentType("application/octet-stream");
						 * response.addHeader("Content-Type",
						 * "application/vnd.android.package-archive");
						 * OutputStream toClient = new BufferedOutputStream(
						 * response.getOutputStream()); try {
						 * toClient.write(buffer); toClient.flush(); } catch
						 * (Exception e) {
						 * 
						 * } finally { toClient.close(); }
						 * 
						 * return; }
						 */
						
						//path = "D:\\" + fileName + ".apk";
						path =fileName+".apk";
					} else {// 如果无法确定用户操作系统类型则跳转到一个JSP，让用户自已选择下载文件类型
						request.getRequestDispatcher(
								"down_app.jsp?fileName=" + fileName).forward(
								request, response);
						return;
					}
				} else {//如果是微信浏览器
					if (userAgent.indexOf("IPHONE") != -1
							|| userAgent.indexOf("IPAD") != -1) {
					/*	response.sendRedirect("ios_temp.jsp?fileName="
								+ fileName);
						return;
					} else if (userAgent.indexOf("ANDROID") != -1
							|| userAgent.indexOf("ADR") != -1) {
						request.getRequestDispatcher(
								"tip.jsp?fileName=" + fileName).forward(
								request, response);
						return;*/
						request.getRequestDispatcher(
								"tip.jsp?fileName=" + fileName).forward(
								request, response);
						return;

					} else {
						request.getRequestDispatcher(
								"down_app.jsp?fileName=" + fileName).forward(
								request, response);
						return ;
					}
				}
			}
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort();
			System.out.println(basePath);
			//response.sendRedirect(basePath+"/appdata/"+path);
			response.sendRedirect(basePath+"/downapp/"+path);
			return;
			/*OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			
			 * String ext = filename.substring(filename.lastIndexOf(".") + 1)
			 * .toUpperCase();
			 

			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));

			byte[] buffer = new byte[fis.available()];
			try {
				fis.read(buffer);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				fis.close();
				System.out.println("关闭输入流");
			}
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ filename);// 下载文件名
			response.addHeader("Content-Length", "" + file.length());// 下载文件大小,前面加空String是为了将文件大小转换为String类型
			response.addHeader("Content-Type",
					"application/vnd.android.package-archive");// 下载文件类型，这里是apk
			try {
				toClient.write(buffer);
				toClient.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				toClient.close();
				System.out.println("关闭输出流");
				buffer = null;   
				System.gc();
				System.out.println("垃圾回收！！");
			}*/
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		doGet(request, response);
	}
}
