package timer;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import task.PortalTask;
/**
 * 定时器，每隔三分钟向服务器发起PORTAL页请求
 * @author wzx
 *
 * @date 2014-9-17
 */
public class PortalListener implements ServletContextListener {

	private Timer timer = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		timer.cancel();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		timer = new Timer(true);
		// 设置任务计划，启动和间隔时间
		timer.schedule(new PortalTask(), 0, 1000*60*3);
	}
}
