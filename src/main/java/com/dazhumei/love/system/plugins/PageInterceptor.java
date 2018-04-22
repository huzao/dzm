//package com.dazhumei.love.system.plugins;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//import org.apache.ibatis.session.Configuration;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//
//import com.dazhumei.love.system.entity.PageResult;
//import com.dazhumei.love.system.entity.PageVO;
//
//
//
//@Intercepts({@Signature(type=Executor.class,method="query",args={MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})})
//public class PageInterceptor implements Interceptor {
//	
//	public Object intercept(Invocation invocation) throws Throwable {
//		Object[] args=invocation.getArgs();
//		MappedStatement ms=(MappedStatement)args[0];
//		String sqlId=ms.getId();
//		Object paramter=args[1];
//		PageVO pageVO=null;
//		pageVO=checkIntercept(sqlId,paramter);
//		if(pageVO==null){
//			return invocation.proceed();
//		}
//		Executor executor=(Executor) invocation.getTarget();
//		getPageCount(pageVO, executor, sqlId, ms, args);
//		List result=null;
//		if(pageVO.getTotal()>0){
//			pageVO.setTotal(pageVO.getTotal());
//			result=getResultList(executor, ms, args);
//		}else{
//			result=Collections.emptyList();
//		}
//		PageResult pageResult=new PageResult();
//		pageResult.setTotal(pageVO.getTotal());
//		pageResult.setRows(result);
//		List<PageResult> resultList=new ArrayList<PageResult>();
//		resultList.add(pageResult);
//		return resultList;
//	}
//	
//	private PageVO checkIntercept(String sqlId,Object paramter){
//		if(sqlId!=null&&sqlId.endsWith("Count")){
//			return null;
//		}
//		if(paramter instanceof PageVO){
//			return (PageVO)paramter;
//		}
//		if(paramter instanceof Map){
//			Map map=(Map) paramter;
//			for (Object obj : map.keySet()) {
//				if(map.get(obj) instanceof PageVO){
//					return (PageVO)map.get(obj);
//				}
//			}
//		}
//		return null;
//	}
//	
//	/**
//	 * @param pageVO
//	 * @param executor
//	 * @param sqlId
//	 * @param ms
//	 * @param args
//	 */
//	private void getPageCount(PageVO pageVO,Executor executor,String sqlId,MappedStatement ms,Object[] args){
//		String countsql=sqlId+"Count";
//		MappedStatement state=ms.getConfiguration().getMappedStatement(countsql);
//		List resultList=new ArrayList();
//		resultList=getResultList(executor,state,args);
//		int total= (Integer)resultList.get(0);
//		pageVO.setTotal(total);
//	}
//
//	private List getResultList(Executor executor,MappedStatement ms,Object[] args){
//		ResultHandler resultHandler=(ResultHandler)args[3];
//		Object paramter=args[1];
//		RowBounds rowBounds=(RowBounds) args[2];
//		List resultList=new ArrayList();
//		Configuration config=ms.getConfiguration();
//		StatementHandler handler=config.newStatementHandler(executor, ms, paramter, rowBounds, resultHandler, null);
//		try {
//			Connection con=executor.getTransaction().getConnection();
//			Statement state=handler.prepare(con);
//			handler.parameterize(state);
//			resultList=handler.query(state, resultHandler);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return resultList;
//	}
//	
//	public Object plugin(Object target) {
//		return Plugin.wrap(target, this);
//	}
//
//	public void setProperties(Properties properties) {
//		
//	}
//
//}
