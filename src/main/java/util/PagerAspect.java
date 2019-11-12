package util;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * 分页切面
 * @author s
 *
 */

@Aspect
@Component
public class PagerAspect {
	@Autowired
	private JdbcTemplate jt;
	//自定义切点
	@Pointcut("execution(* service..*(..))")
	public void selfPointJoin() {}
	
	@Around("selfPointJoin()")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object selfAround(ProceedingJoinPoint jp) {
		//根据jp对象拿到Method方法
		MethodSignature ms = (MethodSignature)jp.getSignature();
		Method method = ms.getMethod();
		
		//更具method方法看看有没有MiniPager标注
		MiniPage miniPager = (MiniPage)method.getAnnotation(MiniPage.class);
		//没有这个标注，执行原始的业务方法
		if(miniPager == null) {
			Object o = null;
			try {
				o = jp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return o;
		}
		//有这个标注加入分页代码
		//1.获取总条目数
		String tableName = miniPager.tableName();
		int totalItems = jt.queryForObject("select count(*) from "+tableName, Integer.class);
		//2.根据页大小，计算总页数
		int pageSize=(Integer)jp.getArgs()[1];
		int pageNo=(Integer)jp.getArgs()[0];
		int totalPages = (totalItems+pageSize-1)/pageSize;
		if(pageNo >= totalPages) {
			pageNo = totalPages;
		}
		//3.返回分页对象
		Pager pager = new Pager();
		try {
			List data = (List)jp.proceed(new Object[] {pageNo,pageSize});
			pager.setData(data);
			pager.setTotal(totalPages);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pager;
	}
	
	
	
}
