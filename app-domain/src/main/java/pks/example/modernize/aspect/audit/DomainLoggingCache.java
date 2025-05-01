package pks.example.modernize.aspect.audit;

import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.JoinPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DomainLoggingCache {

	private static String LOG_CLASS_PREFIX = "audit.";
	private static ConcurrentHashMap<String,Logger> loggerCache = new ConcurrentHashMap<>();

	public static Logger getJoinPointLogger(JoinPoint joinPoint) {

		String category = LOG_CLASS_PREFIX + joinPoint.getSignature().getDeclaringTypeName();
		Logger logger = loggerCache.get(category);

		if (logger == null) { 
			logger = LoggerFactory.getLogger(category);
			loggerCache.put(category,logger);
		}
		return logger;
	}
}
